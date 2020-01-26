package io.rivulet.test;

import io.rivulet.BufferedHttpMessageParser;
import org.apache.http.*;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.io.*;
import org.apache.http.message.BasicHeader;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class BufferedHttpMessageParserTest {

    private static final Header[] headers = new Header[] {
            new BasicHeader(HttpHeaders.HOST, "www.example.com"),
            new BasicHeader(HttpHeaders.ACCEPT, "text/plain; q=0.5, text/html, text/x-dvi; q=0.8, text/x-c"),
            new BasicHeader(HttpHeaders.USER_AGENT, "Mozilla/4.0 (compatible; MSIE5.01; Windows NT)"),
            new BasicHeader(HttpHeaders.CONTENT_TYPE, "text/html; charset=utf-8"),
            new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, "en-us"),
            new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate"),
            new BasicHeader(HttpHeaders.CONNECTION, "Keep-Alive"),
            new BasicHeader(HttpHeaders.DATE, "Fri, 14 Jun 2019 12:00:00 GMT"),
            new BasicHeader(HttpHeaders.SERVER, "Apache/2.2.14 (Win32)"),
            new BasicHeader(HttpHeaders.LAST_MODIFIED, "Wed, 22 Jul 2009 19:15:56 GMT"),
    };
    private static final Header CHUNKED_HEADER = new BasicHeader(HttpHeaders.TRANSFER_ENCODING, "chunked");
    private static final Header TRAILER_HEADER = new BasicHeader(HttpHeaders.TRAILER, HttpHeaders.EXPIRES);
    private static final Header TRAILER = new BasicHeader(HttpHeaders.EXPIRES, "Wed, 01 Jan 2020 12:00:00 GMT");
    @DataPoints
    @SuppressWarnings("unchecked")
    public static List<Header>[] headerLists() {
        return (List<Header>[])new List[]{
                new LinkedList<>(),
                Arrays.asList(headers),
                Arrays.asList(headers[0], headers[2], headers[5]),
                Arrays.asList(headers[3], headers[6]),
                Collections.singletonList(headers[4])
        };
    }
    @DataPoints
    public static String[] entityBodies = new String[] {
            "",
            "<html><body><p>Hello, World!</p></body></html>",
            "\r\nHello, World!\r\n\r\n",
            "Hello, World!\r",
            "\r\nHello, \r\nWorld!\r\n\r\n\nHello, World!\r\n",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque iaculis quis dolor in viverra. In a " +
                    "sagittis diam. Vivamus in turpis sed metus posuere posuere sed et libero. Nullam et ligula ullamcorper, ullamcorper orci " +
                    "id, placerat libero. Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Sed porta orci quis condimentum venenatis"
    };
    @DataPoints
    public static Integer[] appends = new Integer[]{1, 50, 100};
    @DataPoints
    public static Boolean[] options = new Boolean[]{true, false};
    @DataPoints
    public static BufferedHttpMessageParser.ContentEncoding[] encodings = new  BufferedHttpMessageParser.ContentEncoding[] {
            BufferedHttpMessageParser.ContentEncoding.IDENTITY,
            BufferedHttpMessageParser.ContentEncoding.GZIP
    };

    @Theory
    public void testParseResponse(List<Header> headers, String body, BufferedHttpMessageParser.ContentEncoding encoding, Boolean addTrailer, Boolean chunk, Integer numAppends) throws Exception {
        HttpResponse message = new DefaultHttpResponseFactory().newHttpResponse(HttpVersion.HTTP_1_1, 200, null);
        message.setEntity(buildHttpMessageBase(message, headers, body, encoding, addTrailer, chunk, numAppends));
        checkParse(BufferedHttpMessageParser.getResponseParser(8000), setEntityAndGetBytes(message, addTrailer), body, addTrailer, numAppends);
    }

    @Theory
    public void testParseRequest(List<Header> headers, String body, BufferedHttpMessageParser.ContentEncoding encoding, Boolean addTrailer, Boolean chunk, Integer numAppends) throws Exception {
        HttpPost message = new HttpPost("example/path");
        message.setEntity(buildHttpMessageBase(message, headers, body, encoding, addTrailer, chunk, numAppends));
        checkParse(BufferedHttpMessageParser.getRequestParser(8000), setEntityAndGetBytes(message, addTrailer), body, addTrailer, numAppends);
    }

    private void checkParse(BufferedHttpMessageParser parser, byte[] bytes, String body, boolean addTrailer, int numAppends) throws Exception {
        byte[][] chunks = splitByteArr(bytes, numAppends);
        // Append the bytes
        for(byte[] chunk : chunks) {
            parser.appendBytes(chunk);
        }
        // Check that a message was parsed
        assertTrue(parser.hasParsedMessage());
        BufferedHttpMessageParser.ParsedMessage parsed = parser.getParsedMessage();
        // Check that only one message was parsed
        assertFalse(parser.hasParsedMessage());
        Object parsedMessage = parsed.getMessage();
        String entity = parsed.getEntityString();
        Map trailers = parsed.getTrailers();
        assertNotNull(parsedMessage);
        if(body.length() > 0) {
            assertEquals(body, entity);
        }
        if(addTrailer) {
            assertEquals(TRAILER.getValue(), trailers.get(TRAILER.getName()));
        }
    }

    private HttpEntity buildHttpMessageBase(HttpMessage message, List<Header> headers, String body, BufferedHttpMessageParser.ContentEncoding encoding, Boolean addTrailer, Boolean chunk, Integer numAppends) {
        assumeNotNull(headers, body, addTrailer, numAppends);
        // Assume that if the body is empty then the content is not compressed
        assumeTrue(!body.isEmpty() || encoding == BufferedHttpMessageParser.ContentEncoding.IDENTITY);
        // Assume that if there is a trailer, then the transfer-type is chunked
        assumeTrue(!addTrailer || chunk);
        // Add headers
        addHeaders(message, headers);
        if(addTrailer) {
            message.addHeader(TRAILER_HEADER);
        }
        // Add the entity body
        EntityBuilder entityBuilder = EntityBuilder.create();
        if(chunk) {
            entityBuilder.chunked();
        }
        if(encoding == BufferedHttpMessageParser.ContentEncoding.GZIP) {
            entityBuilder.gzipCompress();
        }
        entityBuilder.setContentEncoding(encoding.getHeaderValue());
        entityBuilder.setText(body);
        return entityBuilder.build();
    }

    private byte[] setEntityAndGetBytes(HttpResponse response, boolean addTrailer) throws IOException, HttpException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        SessionOutputBufferImpl buffer = new SessionOutputBufferImpl(new HttpTransportMetricsImpl(), 8000);
        buffer.bind(byteStream);
        DefaultHttpResponseWriter writer = new DefaultHttpResponseWriter(buffer);
        return writeEntityInfo(response, response.getEntity(), addTrailer, buffer, writer, byteStream);
    }

    private byte[] setEntityAndGetBytes(HttpPost request, boolean addTrailer) throws IOException, HttpException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        SessionOutputBufferImpl buffer = new SessionOutputBufferImpl(new HttpTransportMetricsImpl(), 8000);
        buffer.bind(byteStream);
        DefaultHttpRequestWriter writer = new DefaultHttpRequestWriter(buffer);
        return writeEntityInfo(request, request.getEntity(), addTrailer, buffer, writer, byteStream);
    }

    private <T extends HttpMessage> byte[] writeEntityInfo(T message, HttpEntity entity, boolean addTrailer, SessionOutputBufferImpl buffer,
                                   AbstractMessageWriter<T> writer, ByteArrayOutputStream byteStream) throws IOException, HttpException {
        if(entity != null) {
            if(!entity.isChunked()) {
                message.removeHeaders(HttpHeaders.CONTENT_LENGTH);
                message.addHeader(HttpHeaders.CONTENT_LENGTH, ""+entity.getContentLength());
            }
            if(entity.getContentType() != null) {
                message.removeHeaders(HttpHeaders.CONTENT_TYPE);
                message.addHeader(entity.getContentType());
            }
            if(entity.getContentEncoding() != null) {
                message.removeHeaders(HttpHeaders.CONTENT_ENCODING);
                message.addHeader(entity.getContentEncoding());
            }
            if(entity.isChunked()) {
                message.removeHeaders(HttpHeaders.TRANSFER_ENCODING);
                message.addHeader(CHUNKED_HEADER);
            }
        }
        writer.write(message);
        OutputStream out;
        if(entity != null) {
            long len = entity.getContentLength();
            if(entity.isChunked()) {
                out = new ChunkedOutputStream(5, buffer);
            } else if(len >= 0) {
                out = new ContentLengthOutputStream(buffer, len);
            } else {
                out = new IdentityOutputStream(buffer);
            }
            entity.writeTo(out);
            out.flush();
            out.close();
        }
        buffer.flush();
        if(addTrailer) {
            byte[] bytes = byteStream.toByteArray();
            byte[] trailer = (TRAILER.getName() + ": " + TRAILER.getValue()  +"\r\n\r\n").getBytes();
            byte[] res = new byte[bytes.length + trailer.length - 2];
            System.arraycopy(bytes, 0, res, 0, bytes.length - 2);
            System.arraycopy(trailer, 0, res, bytes.length - 2, trailer.length);
            return res;
        } else {
            return byteStream.toByteArray();
        }
    }

    private void addHeaders(HttpMessage message, List<Header> headers) {
        for(Header header : headers) {
            message.addHeader(header);
        }
    }

    /* Splits the specified byte array into the specified number of chunks. */
    public static byte[][] splitByteArr(byte[] arr, int numChunks) {
        byte[][] chunks = new byte[numChunks][];
        int chunkSize = arr.length / numChunks;
        int i = 0;
        for(int r = 0; r < numChunks; r++) {
            chunks[r] = (r == numChunks - 1) ? new byte[arr.length - i] : new byte[chunkSize];
            for (int c = 0; c < chunks[r].length; c++, i++) {
                chunks[r][c] = arr[i];
            }
        }
        return chunks;
    }
}
