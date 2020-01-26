package io.rivulet;

import edu.columbia.cs.psl.phosphor.struct.SinglyLinkedList;
import org.apache.http.*;
import org.apache.http.client.entity.DeflateDecompressingEntity;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.*;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

public class BufferedHttpMessageParser<T extends HttpMessage> {

    // Standard bytes used for an empty line in http
    private static final byte[] CRLF = new byte[]{'\r', '\n'};

    // The current parsing phase
    private HttpPhase currentPhase;
    // Stores bytes that have been read, but have not yet been parsed into a message or entity
    private ByteArrayOutputStream byteStream;
    // Whether the last byte of the last stream read was a carriage return that was stored for the next read.
    private boolean storedCR;
    // If the entity body is chunked, the number of bytes read for the current chunk. If the entity body is not chunked,
    // the total number of entity body bytes read.
    private int entityBytesRead = 0;
    // Parser that should be used to parse the http messages once the byte stream is full enough
    private final AbstractMessageParser<T> parser;
    //  The buffer that the parser uses
    private final SessionInputBufferImpl sessionBuffer;
    // The last http message parsed
    private T message;
    // The content type of the last message parsed
    private ContentType contentType;
    // The content length of the last message parsed
    private long contentLength;
    // The content encoding of the last message parsed
    private ContentEncoding contentEncoding;
    // The entity of the last http message parsed
    private HttpEntity entity;
    // The trailers of the last http message parsed
    private LinkedHashMap<String, String> trailers;
    // Builds the hex string of the next chunk's length
    private StringBuilder chunkSizeBuilder;
    // The size of the next chunk
    private long currentChunkSize;
    // Queue of messages parsed by this instance.
    private final SinglyLinkedList<ParsedMessage<T>> parsedMessageQueue;

    /* Constructs a new buffered parser that use the specified parser to parse the HttpMessage instance when enough bytes
     * have been written. */
    private BufferedHttpMessageParser(AbstractMessageParser<T> parser, SessionInputBufferImpl sessionBuffer) {
        this.parser = parser;
        this.sessionBuffer = sessionBuffer;
        this.parsedMessageQueue = new SinglyLinkedList<>();
        this.byteStream = new ByteArrayOutputStream();
        this.storedCR = false;
        reset();
    }

    /* Resets this instance to start parsing an entirely new message. */
    private void reset() {
        this.currentPhase = HttpPhase.PRE_START_LINE;
        this.entityBytesRead = 0;
        this.sessionBuffer.clear();
        this.message = null;
        this.contentType = null;
        this.contentLength = 0;
        this.contentEncoding = null;
        this.entity = null;
        this.trailers = null;
        this.chunkSizeBuilder = new StringBuilder();
        this.currentChunkSize = 0;
    }

    /* Writes bytes from the specified buffer to this instance's byte stream. */
    public void appendBytes(ByteBuffer buffer) throws IOException, HttpException {
        appendBytes(buffer, 0, buffer.remaining());
    }

    /* Writes bytes from the specified buffer to this instance's byte stream. */
    public void appendBytes(ByteBuffer buffer, int offset, int len) throws IOException, HttpException {
        ByteBuffer shallowCopy = buffer.duplicate();
        byte[] arr = new byte[len];
        shallowCopy.get(arr, offset, len);
        appendBytes(arr);
    }

    /* Writes bytes from the specified array to this instance's byte stream. */
    public void appendBytes(byte[] bytes) throws IOException, HttpException {
        if(bytes.length > 0) {
            boolean trailingCR = bytes[bytes.length - 1] == CRLF[0];
            PushbackInputStream stream = new PushbackInputStream(new ByteArrayInputStream(bytes, 0, trailingCR ? bytes.length - 1 : bytes.length), bytes.length + 1);
            if(storedCR) {
                // If a carriage return is stored from a previous append add it to the front of the input stream
                stream.unread(CRLF[0]);
            }
            storedCR = trailingCR;
            appendBytes(stream);
        }
    }

    /* Writes bytes from the specified stream to this instance's byte stream. */
    private void appendBytes(PushbackInputStream stream) throws IOException, HttpException {
        while(stream.available() > 0) {
            switch(currentPhase) {
                case PRE_START_LINE:
                    if(!consumeEmptyLines(stream, false)) {
                        currentPhase = HttpPhase.START_LINE;
                    }
                    break;
                case START_LINE:
                case HEADER:
                    if(!consumeNonEmpty(stream)) {
                        currentPhase = HttpPhase.PRE_HEADER;
                    }
                    break;
                case PRE_HEADER:
                    if(!consumeEmptyLine(stream, true)) {
                        currentPhase = HttpPhase.HEADER;
                        break;
                    }
                    currentPhase =  HttpPhase.PRE_MESSAGE_BODY;
                case PRE_MESSAGE_BODY:
                    parseMessage();
                    currentPhase = (contentLength == ContentLengthStrategy.CHUNKED) ? HttpPhase.CHUNK_SIZE : HttpPhase.IDENTITY_BODY;
                    entityBytesRead = 0;
                    if(currentPhase != HttpPhase.IDENTITY_BODY) {
                        break;
                    }
                case IDENTITY_BODY:
                    if(entityBytesRead != contentLength && stream.available() > 0) {
                        byteStream.write(stream.read());
                        entityBytesRead++;
                    }
                    if(stream.available() == 0 && storedCR && (entityBytesRead + 1) == contentLength) {
                        // Last byte of body is a carriage return
                        byteStream.write(CRLF[0]);
                        storedCR = false;
                        entityBytesRead++;
                    }
                    if(entityBytesRead == contentLength) {
                        parseEntity();
                        // A request was parsed, store it and reset
                        parsedMessageQueue.enqueue(new ParsedMessage<>(message, entity, trailers));
                        reset();
                    }
                    break;
                case CHUNK_SIZE:
                    if(consumeEmptyLine(stream, true)) {
                        this.currentChunkSize = Long.parseLong(chunkSizeBuilder.toString(), 16);
                        chunkSizeBuilder = new StringBuilder();
                        currentPhase = HttpPhase.CHUNK_DATA;
                    } else if(consumeSemicolon(stream)) {
                        this.currentChunkSize = Long.parseLong(chunkSizeBuilder.toString(), 16);
                        chunkSizeBuilder = new StringBuilder();
                        currentPhase = HttpPhase.CHUNK_EXT;
                    } else {
                        int read = stream.read();
                        chunkSizeBuilder.append((char)read);
                        byteStream.write(read);
                    }
                    break;
                case CHUNK_EXT:
                    if(!consumeNonEmpty(stream)) {
                        currentPhase = HttpPhase.CHUNK_DATA;
                    }
                    break;
                case CHUNK_DATA:
                    if(currentChunkSize == 0) {
                        // Ending chunk
                        entityBytesRead = 0;
                        parseEntity();
                        currentPhase = HttpPhase.PRE_TRAILER;
                    } else if(entityBytesRead == currentChunkSize) {
                        entityBytesRead = 0;
                        consumeEmptyLine(stream, true);
                        currentPhase = HttpPhase.CHUNK_SIZE;
                    } else {
                        byteStream.write(stream.read());
                        entityBytesRead++;
                    }
                    break;
                case PRE_TRAILER:
                    if(consumeEmptyLine(stream, true)) {
                        parseTrailer();
                        // A request was parsed, store it and reset
                        parsedMessageQueue.enqueue(new ParsedMessage<>(message, entity, trailers));
                        reset();
                    } else {
                        currentPhase = HttpPhase.TRAILER;
                    }
                    break;
                case TRAILER:
                    if(!consumeNonEmpty(stream)) {
                        currentPhase = HttpPhase.PRE_TRAILER;
                    }
                    break;
            }
        }
    }

    /* Reads the next thing on the buffer. If it is an empty line add it to this instance's byteStream in write is true
     * and returns true. Otherwise, pushes it back onto the stream and returns false.*/
    private boolean consumeEmptyLine(PushbackInputStream stream, boolean write) throws IOException {
        if(stream.available() > 1) {
            int first = stream.read();
            int second = stream.read();
            if(first == CRLF[0] && second == CRLF[1]) {
                // The pair read was a empty line
                if(write) {
                    byteStream.write(first);
                    byteStream.write(second);
                }
                return true;
            } else {
                // The pair read was not an empty line
                stream.unread(second);
                stream.unread(first);
                return false;
            }
        } else {
            return false;
        }
    }

    /* Reads the next thing on the buffer. If it is a ';' adds it to this instance's byteStream and returns true.
     * Otherwise, pushes it back onto the stream and returns false.*/
    private boolean consumeSemicolon(PushbackInputStream stream) throws IOException {
        if(stream.available() > 0) {
            int read = stream.read();
            if(read == ';') {
                byteStream.write(read);
                return true;
            } else {
                stream.unread(read);
                return false;
            }
        } else {
            return false;
        }
    }

    /* Reads from the specified buffer into this instance's byte stream until the next thing on the buffer is not an empty
     * line if write is true. Otherwise Reads from the specified buffer until the next thing on the buffer is not an empty
     * line but does not write those empty lines to the byte stream. Returns whether the entire stream was consumed. */
    private boolean consumeEmptyLines(PushbackInputStream stream, boolean write) throws IOException {
        while(consumeEmptyLine(stream, write));
        return stream.available() == 0;
    }

    /* Reads from the specified buffer into this instance's byte stream until the next thing on the buffer is an empty
     * line. Returns whether the entire stream was consumed before an empty line was encountered. */
    private boolean consumeNonEmpty(PushbackInputStream stream) throws IOException {
        boolean lastReadCR = false;
        while(stream.available() > 0) {
            int read = stream.read();
            byteStream.write(read);
            if(read == CRLF[0]) {
                lastReadCR = true;
            } else if(read == CRLF[1] && lastReadCR) {
                // An empty line was found and consumed
                return false;
            }
        }
        return true;
    }

    /* Parses the bytes currently in this instance's byte stream into an http message. */
    private void parseMessage() throws IOException, HttpException {
        this.message = null;
        sessionBuffer.clear();
        sessionBuffer.bind(new ByteArrayInputStream(byteStream.toByteArray()));
        this.message = parser.parse();
        // Set the byte stream to contain the remaining bytes in the session buffer
        byteStream.reset();
        byte[] remaining = new byte[sessionBuffer.length()];
        sessionBuffer.read(remaining);
        byteStream.write(remaining);
        // Determine the content type
        try {
            this.contentType = ContentType.parse(message.getFirstHeader(HTTP.CONTENT_TYPE).getValue());
        } catch(Exception e) {
            this.contentType = null;
        }
        // Determine the content length
        this.contentLength = StrictContentLengthStrategy.INSTANCE.determineLength(message);
        if(this.contentLength != ContentLengthStrategy.CHUNKED) {
            try {
                this.contentLength = Long.parseLong(message.getFirstHeader(HTTP.CONTENT_LEN).getValue());
            } catch(Exception e) {
                contentLength = 0;
            }
        }
        // Determine the content encoding
        try {
            this.contentEncoding = ContentEncoding.parse(message.getFirstHeader(HTTP.CONTENT_ENCODING));
        } catch(Exception e) {
            this.contentEncoding = ContentEncoding.IDENTITY;
        }
    }

    /* Parses the bytes currently in this instance's byte stream into a body entity. */
    private void parseEntity() {
        this.entity = null;
        sessionBuffer.clear();
        sessionBuffer.bind(new ByteArrayInputStream(byteStream.toByteArray()));
        if(contentLength == ContentLengthStrategy.CHUNKED) {
            this.entity = new InputStreamEntity(new ChunkedInputStream(sessionBuffer), -1, contentType);
        } else if(contentLength == ContentLengthStrategy.IDENTITY) {
            this.entity = new InputStreamEntity(new IdentityInputStream(sessionBuffer), -1, contentType);
        } else if(contentLength > 0) {
            this.entity = new InputStreamEntity(new ContentLengthInputStream(sessionBuffer, contentLength), contentLength, contentType);
        }
        // Decompress the entity if needed
        if(entity != null) {
            if(contentEncoding == ContentEncoding.GZIP) {
                this.entity = new GzipDecompressingEntity(this.entity);
            } else if(contentEncoding == ContentEncoding.DEFLATE) {
                this.entity = new DeflateDecompressingEntity(this.entity);
            }
        }
        // Reset the byte stream
        byteStream.reset();
    }

    /* Parses the bytes currently in this instance's byte stream into a trailing header String. */
    private void parseTrailer() {
        String trailerString = new String(byteStream.toByteArray()).trim();
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for(String trailer : trailerString.split("\r\n")) {
            int splitIndex = trailer.indexOf(":");
            if(splitIndex != -1) {
                String name = trailer.substring(0, splitIndex).trim();
                String value = trailer.substring(splitIndex+1).trim();
                map.put(name, value);
            }
        }
        this.trailers = map;
        // Reset the byte stream
        byteStream.reset();
    }

    /* Returns whether this instance has at least one parsed message waiting to be dequeued. */
    public boolean hasParsedMessage() {
        return !parsedMessageQueue.isEmpty();
    }

    /* Removes and returns the first parsed message in this instance's queue. */
    public ParsedMessage<T> getParsedMessage() {
        return parsedMessageQueue.dequeue();
    }

    /* Returns a new instance of BufferedHttpMessageParser for parsing HttpResponse instances with the specified session
     * buffer size. */
    public static BufferedHttpMessageParser<HttpResponse> getResponseParser(int bufferSize) {
        SessionInputBufferImpl sessionBuffer = new SessionInputBufferImpl(new HttpTransportMetricsImpl(), bufferSize);
        DefaultHttpResponseParser responseParser = new DefaultHttpResponseParser(sessionBuffer);
        return new BufferedHttpMessageParser<>(responseParser, sessionBuffer);
    }

    /* Returns a new instance of BufferedHttpMessageParser for parsing HttpRequest instances with the specified session
     * buffer size. */
    public static BufferedHttpMessageParser<HttpRequest> getRequestParser(int bufferSize) {
        SessionInputBufferImpl sessionBuffer = new SessionInputBufferImpl(new HttpTransportMetricsImpl(), bufferSize);
        DefaultHttpRequestParser requestParser = new DefaultHttpRequestParser(sessionBuffer);
        return new BufferedHttpMessageParser<>(requestParser, sessionBuffer);
    }

    /* Returns a new instance of BufferedHttpMessageParser for parsing HttpResponse instances. */
    public static BufferedHttpMessageParser<HttpResponse> getResponseParser() {
        return getResponseParser(8192);
    }

    /* Returns a new instance of BufferedHttpMessageParser for parsing HttpRequest instances. */
    public static BufferedHttpMessageParser<HttpRequest> getRequestParser() {
        return getRequestParser(8192);
    }

    public enum HttpPhase {
        PRE_START_LINE,
        START_LINE,
        PRE_HEADER,
        HEADER,
        PRE_MESSAGE_BODY,
        IDENTITY_BODY,
        CHUNK_SIZE,
        CHUNK_EXT,
        CHUNK_DATA,
        PRE_TRAILER,
        TRAILER
    }

    public enum ContentEncoding {
        GZIP("gzip"),
        DEFLATE("deflate"),
        IDENTITY("identity");

        private final String headerValue;

        ContentEncoding(String headerValue) {
            this.headerValue = headerValue;
        }

        public String getHeaderValue() {
            return headerValue;
        }

        /* Returns a ContentEncoding instance based on the value of the specified header. Defaults to identity encoding
         * if the specified header is null or doesn't match the values for gzip or deflate. */
        public static ContentEncoding parse(Header contentEncodingHeader) {
            if(contentEncodingHeader == null) {
                return IDENTITY;
            }
            return parse(contentEncodingHeader.getValue());
        }

        /* Returns a ContentEncoding instance based on the specified value. Defaults to identity encoding if the specified
         * value is null or doesn't match the values for gzip or deflate. */
        public static ContentEncoding parse(String value) {
            if(value == null) {
                return IDENTITY;
            } else {
                value = value.toLowerCase().trim();
            }
            switch(value) {
                case "gzip":
                case "x-gzip":
                    return GZIP;
                case "deflate":
                    return DEFLATE;
                default:
                    return IDENTITY;
            }
        }
    }

    /* Record type that groups parsed information together. */
    public static class ParsedMessage<T extends HttpMessage> {

        private final T message;
        private final HttpEntity entity;
        private final LinkedHashMap<String, String> trailers;

        /* Constructs a new ParsedMessage with the specified information. */
        ParsedMessage(T message, HttpEntity entity, LinkedHashMap<String, String> trailers) {
            this.message = message;
            this.entity = entity;
            this.trailers = trailers == null ? new LinkedHashMap<>() : trailers;
        }

        /* Getter for message. */
        public T getMessage() {
            return message;
        }

        /* Getter for entity. */
        public HttpEntity getEntity() {
            return entity;
        }

        /* Returns a String representation of this instance's entity. */
        public String getEntityString() throws IOException {
            try {
                return (entity == null) ? null : EntityUtils.toString(entity);
            } finally {
                if(entity != null) {
                    EntityUtils.consume(entity);
                }
            }
        }

        /* Return whether this instance has an entity whose content is text/html or not specified. */
        public Boolean hasHtmlContent() {
            return entity != null && (entity.getContentType() == null
                    || ContentType.get(entity).getMimeType().toLowerCase().equals(ContentType.TEXT_HTML.getMimeType().toLowerCase()));
        }

        /* Getter for trailers */
        public Map<String, String> getTrailers() {
            return trailers;
        }
    }
}
