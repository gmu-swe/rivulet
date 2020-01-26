package io.rivulet;

import io.rivulet.internal.RestructureRequestBytesCV;
import io.rivulet.internal.TaintedStringBuilder;
import org.apache.http.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/* Represents an HTTP request. Capable of converting the request it represents into a byte array using fine-grain public
 * accessor methods which make excellent auto-taint source methods. */
@SuppressWarnings("unused")
public class PhosphorHttpRequest implements Serializable {

    private static final long serialVersionUID = -2622573790320306202L;
    // The length of randomly generated boundaries for multipart/form-data content
    private static final int BOUNDARY_LEN = 35;
    // Characters used when generating boundaries for multipart/form-data content
    private static final char[] BOUNDARY_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    // Carriage return and line feed characters used to indicate the end of a line.
    private static final String CRLF = "\r\n";
    // The string name of the cookie header
    private static final String COOKIE_HEADER = "Cookie";
    // The string name of the upgrade-insecure-requests header
    private static final String UPGRADE_INSECURE_REQUESTS_HEADER = "Upgrade-Insecure-Requests";
    // List of common HTTP header names
    private static final List<String> COMMON_HEADERS = Arrays.asList(COOKIE_HEADER, UPGRADE_INSECURE_REQUESTS_HEADER,
            HttpHeaders.ACCEPT, HttpHeaders.ACCEPT_CHARSET, HttpHeaders.ACCEPT_LANGUAGE, HttpHeaders.ACCEPT_RANGES,
            HttpHeaders.AGE, HttpHeaders.ALLOW, HttpHeaders.AUTHORIZATION, HttpHeaders.CACHE_CONTROL, HttpHeaders.CONNECTION,
            HttpHeaders.CONTENT_LANGUAGE, HttpHeaders.CONTENT_LOCATION, HttpHeaders.CONTENT_MD5, HttpHeaders.CONTENT_RANGE,
            HttpHeaders.CONTENT_TYPE, HttpHeaders.DATE, HttpHeaders.DAV, HttpHeaders.DEPTH, HttpHeaders.DESTINATION,
            HttpHeaders.ETAG, HttpHeaders.EXPECT, HttpHeaders.EXPIRES, HttpHeaders.FROM, HttpHeaders.HOST, HttpHeaders.IF,
            HttpHeaders.IF_MATCH, HttpHeaders.IF_MODIFIED_SINCE, HttpHeaders.IF_NONE_MATCH, HttpHeaders.IF_RANGE,
            HttpHeaders.IF_UNMODIFIED_SINCE, HttpHeaders.LAST_MODIFIED, HttpHeaders.LOCATION, HttpHeaders.LOCK_TOKEN, HttpHeaders.MAX_FORWARDS,
            HttpHeaders.OVERWRITE, HttpHeaders.PRAGMA, HttpHeaders.PROXY_AUTHENTICATE, HttpHeaders.PROXY_AUTHORIZATION,
            HttpHeaders.RANGE, HttpHeaders.REFERER, HttpHeaders.RETRY_AFTER, HttpHeaders.SERVER, HttpHeaders.STATUS_URI,
            HttpHeaders.TE, HttpHeaders.TIMEOUT, HttpHeaders.TRAILER, HttpHeaders.TRANSFER_ENCODING,
            HttpHeaders.UPGRADE, HttpHeaders.USER_AGENT, HttpHeaders.VARY, HttpHeaders.VIA, HttpHeaders.WARNING, HttpHeaders.WWW_AUTHENTICATE
    );
    // List of http header names for headers whose values are replaced
    private static final List<String> REPLACED_HEADERS = Arrays.asList(HttpHeaders.ACCEPT_ENCODING,
            HttpHeaders.CONTENT_ENCODING, HttpHeaders.CONTENT_LENGTH);
    // Max size of chunks for chunked message bodies
    private static final int MAX_CHUNK_SIZE = 4096;
    // Hex string for MAX_CHUNK_SIZE
    private static final String MAX_CHUNK_STR = "1000";
    // Maps channels to the parser used to parse bytes read from it
    private static final Map<ByteChannel, BufferedHttpMessageParser<HttpRequest>> parserMap = new ConcurrentHashMap<>();
    // Tracks the String representations of PhosphorHttpRequest that have been returned by calls to requestFromSocket by
    // structureRequestBytes.
    private static final List<String> interceptedRequests = new LinkedList<>();

    // Part of the request line, indicates the method to be performed
    private final String method;
    // Part of the request line, indicates the resource the request applies to
    private final URI uri;
    // Part of the request line, indicates the version of HTTP used
    private final String protocolVersion;
    // Maps commonly used HTTP message header names to their values for this request
    private final HashMap<String, String> commonHeaders;
    // Maps non-common HTTP message header names to their values for this request
    private final LinkedHashMap<String, String> uncommonHeaders;
    // The String entity body of the request or null if no entity body is present
    private final String entityBody;
    // Maps HTTP message trailer names to their values for this request
    private final TreeMap<String, String> trailers;

    /* Constructs a new PhosphorHttpRequest containing information from the specified HttpRequest. */
    public PhosphorHttpRequest(HttpRequest request, HttpEntity entity, Map<String, String> trailers) throws URISyntaxException, IOException {
        this.method = request.getRequestLine().getMethod();
        this.uri = new URI(request.getRequestLine().getUri());
        this.protocolVersion = request.getProtocolVersion().toString();
        this.commonHeaders = new HashMap<>();
        this.uncommonHeaders = new LinkedHashMap<>();
        this.trailers = new TreeMap<>(trailers);
        for(Header header : request.getAllHeaders()) {
            addHeader(header);
        }
        if(entity != null) {
            String body = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            // Try to replace the boundary to one of a fixed length if entity is has multipart/form-data content
            try {
                String contentType = commonHeaders.get(HttpHeaders.CONTENT_TYPE);
                if(contentType != null && contentType.toLowerCase().contains(ContentType.MULTIPART_FORM_DATA.getMimeType().toLowerCase())) {
                    String boundary = contentType.substring(contentType.indexOf("boundary=")+"boundary=".length()).trim();
                    String fixedBoundary = generateBoundary();
                    commonHeaders.put(HttpHeaders.CONTENT_TYPE, contentType.replace(boundary, fixedBoundary));
                    if(body != null ) {
                        body = body.replace(boundary, fixedBoundary);
                    }
                }
            } catch(Exception e) {
                //
            }
            this.entityBody = body;
        } else {
            this.entityBody = null;
        }
    }

    /* Generates a random boundary of a fixed length for multipart/form-data content. */
    private static String generateBoundary() {
        final StringBuilder builder = new StringBuilder();
        final Random rand = ThreadLocalRandom.current();
        for(int i = 0; i < BOUNDARY_LEN; i++) {
            builder.append(BOUNDARY_CHARS[rand.nextInt(BOUNDARY_CHARS.length)]);
        }
        return builder.toString();
    }

    /* Adds the specified header to either the list of common header or the list of other header. */
    private void addHeader(Header header) {
        String name = header.getName();
        String value = header.getValue();
        // Skip any header whose value is replaced
        for(String replaceHeader : REPLACED_HEADERS) {
            if(header.getName().equalsIgnoreCase(replaceHeader)) {
                return;
            }
        }
        // Check if this is a common header
        for(String commonHeader : COMMON_HEADERS) {
            if(header.getName().equalsIgnoreCase(commonHeader)) {
                commonHeaders.put(commonHeader, value);
                return;
            }
        }
        // Header name did not match any of the common headers
        uncommonHeaders.put(name, value);
    }

    /* Returns the HTTP method specifying the action to be performed by this request. */
    public String getMethod() {
        return method;
    }

    /* Returns this request's URI's scheme or null if undefined. */
    public String getScheme() {
        return uri.getScheme();
    }

    /* Returns this request's URI's fragment component or null if undefined. */
    public String getFragment() {
        return uri.getFragment();
    }

    /* Returns this request's URI's user-information or null if undefined. */
    public String getUserInfo() {
        return uri.getUserInfo();
    }

    /* Returns this request's URI's host or null if undefined. */
    public String getHost() {
        if(uri.getHost() == null && uri.getAuthority() != null) {
           String authority = uri.getAuthority();
           if(authority.contains(":")) {
               return authority.substring(0, authority.lastIndexOf(':'));
           } else {
               return authority;
           }
        } else {
            return uri.getHost();
        }
    }

    /* Returns this request's URI's port or -1 if undefined. */
    public int getPort() {
        if(uri.getHost() == null && uri.getAuthority() != null) {
            String authority = uri.getAuthority();
            if(authority.contains(":")) {
                try {
                    return Integer.parseInt(authority.substring(authority.lastIndexOf(':')+1));
                } catch(Exception e) {
                    return -1;
                }

            } else {
                return -1;
            }
        } else {
            return uri.getPort();
        }
    }

    /* Returns this request's URI's encoded path or null if undefined. */
    public String getEncodedPath() {
        return uri.getRawPath();
    }

    /* Returns this request's URI's encoded query or null if undefined. */
    public String getEncodedQuery() {
        return uri.getRawQuery();
    }

    /* Returns a string indicating the version of HTTP used for this request. */
    public String getProtocolVersion() {
        return protocolVersion;
    }

    /* Returns the map of uncommon headers for this request. */
    public Map<String, String> getUncommonHeaders() {
        return uncommonHeaders;
    }

    /* Returns the value of the accept header or null if undefined. */
    public String getAcceptHeader() {
        return commonHeaders.get(HttpHeaders.ACCEPT);
    }

    /* Returns the value of the accept-charset header or null if undefined. */
    public String getAcceptCharsetHeader() {
        return commonHeaders.get(HttpHeaders.ACCEPT_CHARSET);
    }

    /* Returns the value of the accept-language header or null if undefined. */
    public String getAcceptLanguageHeader() {
        return commonHeaders.get(HttpHeaders.ACCEPT_LANGUAGE);
    }

    /* Returns the value of the accept-ranges header or null if undefined. */
    public String getAcceptRangesHeader() {
        return commonHeaders.get(HttpHeaders.ACCEPT_RANGES);
    }

    /* Returns the value of the age header or null if undefined. */
    public String getAgeHeader() {
        return commonHeaders.get(HttpHeaders.AGE);
    }

    /* Returns the value of the allow header or null if undefined. */
    public String getAllowHeader() {
        return commonHeaders.get(HttpHeaders.ALLOW);
    }

    /* Returns the value of the authorization header or null if undefined. */
    public String getAuthorizationHeader() {
        return commonHeaders.get(HttpHeaders.AUTHORIZATION);
    }

    /* Returns the value of the cache-control header or null if undefined. */
    public String getCacheControlHeader() {
        return commonHeaders.get(HttpHeaders.CACHE_CONTROL);
    }

    /* Returns the value of the connection header or null if undefined. */
    public String getConnectionHeader() {
        return commonHeaders.get(HttpHeaders.CONNECTION);
    }

    /* Returns the value of the content-language header or null if undefined. */
    public String getContentLanguageHeader() {
        return commonHeaders.get(HttpHeaders.CONTENT_LANGUAGE);
    }

    /* Returns the value of the content-location header or null if undefined. */
    public String getContentLocationHeader() {
        return commonHeaders.get(HttpHeaders.CONTENT_LOCATION);
    }

    /* Returns the value of the content-md5 header or null if undefined. */
    public String getContentMd5Header() {
        return commonHeaders.get(HttpHeaders.CONTENT_MD5);
    }

    /* Returns the value of the content-range header or null if undefined. */
    public String getContentRangeHeader() {
        return commonHeaders.get(HttpHeaders.CONTENT_RANGE);
    }

    /* Returns the value of the content-type header or null if undefined. */
    public String getContentTypeHeader() {
        return commonHeaders.get(HttpHeaders.CONTENT_TYPE);
    }

    /* Returns the value of the cookie header or null if undefined. */
    public String getCookieHeader() {
        return commonHeaders.get(COOKIE_HEADER);
    }

    /* Returns the value of the date header or null if undefined. */
    public String getDateHeader() {
        return commonHeaders.get(HttpHeaders.DATE);
    }

    /* Returns the value of the dav header or null if undefined. */
    public String getDavHeader() {
        return commonHeaders.get(HttpHeaders.DAV);
    }

    /* Returns the value of the depth header or null if undefined. */
    public String getDepthHeader() {
        return commonHeaders.get(HttpHeaders.DEPTH);
    }

    /* Returns the value of the destination header or null if undefined. */
    public String getDestinationHeader() {
        return commonHeaders.get(HttpHeaders.DESTINATION);
    }

    /* Returns the value of the ETag header or null if undefined. */
    public String getETagHeader() {
        return commonHeaders.get(HttpHeaders.ETAG);
    }

    /* Returns the value of the expect header or null if undefined. */
    public String getExpectHeader() {
        return commonHeaders.get(HttpHeaders.EXPECT);
    }

    /* Returns the value of the expires header or null if undefined. */
    public String getExpiresHeader() {
        return commonHeaders.get(HttpHeaders.EXPIRES);
    }

    /* Returns the value of the from header or null if undefined. */
    public String getFromHeader() {
        return commonHeaders.get(HttpHeaders.FROM);
    }

    /* Returns the value of the host header or null if undefined. */
    public String getHostHeader() {
        return commonHeaders.get(HttpHeaders.HOST);
    }

    /* Returns the value of the if header or null if undefined. */
    public String getIfHeader() {
        return commonHeaders.get(HttpHeaders.IF);
    }

    /* Returns the value of the if-match header or null if undefined. */
    public String getIfMatchHeader() {
        return commonHeaders.get(HttpHeaders.IF_MATCH);
    }

    /* Returns the value of the if-modified-since header or null if undefined. */
    public String getIfModifiedSinceHeader() {
        return commonHeaders.get(HttpHeaders.IF_MODIFIED_SINCE);
    }

    /* Returns the value of the if-none-match header or null if undefined. */
    public String getIfNoneMatchHeader() {
        return commonHeaders.get(HttpHeaders.IF_NONE_MATCH);
    }

    /* Returns the value of the if-range header or null if undefined. */
    public String getIfRangeHeader() {
        return commonHeaders.get(HttpHeaders.IF_RANGE);
    }

    /* Returns the value of the if-unmodified-since header or null if undefined. */
    public String getIfUnmodifiedSinceHeader() {
        return commonHeaders.get(HttpHeaders.IF_UNMODIFIED_SINCE);
    }

    /* Returns the value of the last-modified header or null if undefined. */
    public String getLastModifiedHeader() {
        return commonHeaders.get(HttpHeaders.LAST_MODIFIED);
    }

    /* Returns the value of the location header or null if undefined. */
    public String getLocationHeader() {
        return commonHeaders.get(HttpHeaders.LOCATION);
    }

    /* Returns the value of the lock-token header or null if undefined. */
    public String getLockTokenHeader() {
        return commonHeaders.get(HttpHeaders.LOCK_TOKEN);
    }

    /* Returns the value of the max-forwards header or null if undefined. */
    public String getMaxForwardsHeader() {
        return commonHeaders.get(HttpHeaders.MAX_FORWARDS);
    }

    /* Returns the value of the overwrite header or null if undefined. */
    public String getOverwriteHeader() {
        return commonHeaders.get(HttpHeaders.OVERWRITE);
    }

    /* Returns the value of the pragma header or null if undefined. */
    public String getPragmaHeader() {
        return commonHeaders.get(HttpHeaders.PRAGMA);
    }

    /* Returns the value of the proxy-authenticate header or null if undefined. */
    public String getProxyAuthenticateHeader() {
        return commonHeaders.get(HttpHeaders.PROXY_AUTHENTICATE);
    }

    /* Returns the value of the proxy-authorization header or null if undefined. */
    public String getProxyAuthorizationHeader() {
        return commonHeaders.get(HttpHeaders.PROXY_AUTHORIZATION);
    }

    /* Returns the value of the range header or null if undefined. */
    public String getRangeHeader() {
        return commonHeaders.get(HttpHeaders.RANGE);
    }

    /* Returns the value of the referer header or null if undefined. */
    public String getRefererHeader() {
        return commonHeaders.get(HttpHeaders.REFERER);
    }

    /* Returns the value of the retry-after header or null if undefined. */
    public String getRetryAfterHeader() {
        return commonHeaders.get(HttpHeaders.RETRY_AFTER);
    }

    /* Returns the value of the server header or null if undefined. */
    public String getServerHeader() {
        return commonHeaders.get(HttpHeaders.SERVER);
    }

    /* Returns the value of the status-uri header or null if undefined. */
    public String getStatusUriHeader() {
        return commonHeaders.get(HttpHeaders.STATUS_URI);
    }

    /* Returns the value of the te header or null if undefined. */
    public String getTeHeader() {
        return commonHeaders.get(HttpHeaders.TE);
    }

    /* Returns the value of the timeout header or null if undefined. */
    public String getTimeoutHeader() {
        return commonHeaders.get(HttpHeaders.TIMEOUT);
    }

    /* Returns the value of the trailer header or null if undefined. */
    public String getTrailerHeader() {
        return commonHeaders.get(HttpHeaders.TRAILER);
    }

    /* Returns the value of the transfer-encoding header or null if undefined. */
    public String getTransferEncodingHeader() {
        return commonHeaders.get(HttpHeaders.TRANSFER_ENCODING);
    }

    /* Returns the value of the upgrade header or null if undefined. */
    public String getUpgradeHeader() {
        return commonHeaders.get(HttpHeaders.UPGRADE);
    }

    /* Returns the value of the upgrade-insecure-requests header or null if undefined. */
    public String getUpgradeInsecureRequestsHeader() {
        return commonHeaders.get(UPGRADE_INSECURE_REQUESTS_HEADER);
    }

    /* Returns the value of the user-agent header or null if undefined. */
    public String getUserAgentHeader() {
        return commonHeaders.get(HttpHeaders.USER_AGENT);
    }

    /* Returns the value of the vary header or null if undefined. */
    public String getVaryHeader() {
        return commonHeaders.get(HttpHeaders.VARY);
    }

    /* Returns the value of the via header or null if undefined. */
    public String getViaHeader() {
        return commonHeaders.get(HttpHeaders.VIA);
    }

    /* Returns the value of the warning header or null if undefined. */
    public String getWarningHeader() {
        return commonHeaders.get(HttpHeaders.WARNING);
    }

    /* Returns the value of the www-authenticate header or null if undefined. */
    public String getWWWAuthenticateHeader() {
        return commonHeaders.get(HttpHeaders.WWW_AUTHENTICATE);
    }

    /* Returns the string value of this request's entity body or null if no entity body is present. */
    public String getEntityBody() {
        return entityBody;
    }

    /* Returns the trailers for the request. */
    public Map<String, String> getTrailers() {
        return  trailers;
    }

    /* Adds this request's URI information to the specified StringBuilder. */
    private void addURIInfo(StringBuilder builder) throws Exception {
        String scheme = getScheme();
        String userInfo = getUserInfo();
        String host = getHost();
        String fragment = getFragment();
        int port = getPort();
        String encodedPath = getEncodedPath();
        String encodedQuery = getEncodedQuery();
        URIBuilder uriBuilder = new URIBuilder().setCharset(Consts.UTF_8);
        if(scheme != null) {
            uriBuilder.setScheme(scheme);
        }
        if(userInfo != null) {
            uriBuilder.setUserInfo(userInfo);
        }
        if(host != null) {
            uriBuilder.setHost(host);
        }
        if(fragment != null) {
            uriBuilder.setFragment(fragment);
        }
        if(port >= 0) {
            uriBuilder.setPort(port);
        }
        if(encodedPath != null) {
            addEncodedPathString(uriBuilder, encodedPath);
        }
        builder.append(uriBuilder.toString());
        if(encodedQuery != null) {
            builder.append('?').append(encodedQuery);
        }
    }

    /* Adds an encoded path string to the specified URIBuilder. */
    private static void addEncodedPathString(URIBuilder uriBuilder, String path) throws IllegalAccessException {
        Field pathField = getField(uriBuilder, "encodedPath", String.class);
        if(pathField == null) {
            throw new RuntimeException("Could not find encodedPath field for URIBuilder instance");
        } else {
            pathField.set(uriBuilder, path);
        }
    }

    /* Adds this request's header information to the specified StringBuilder. Returns whether an array of booleans indicating
     * whether there is a non-null trailer header for this request and where this request has chunked transfer encoding. */
    private boolean[] addHeaderInfo(StringBuilder builder) {
        boolean hasTrailerHeader;
        boolean hasChunkedTransferEncoding;
        // Add common headers
        String temp = getAcceptHeader();
        if(temp != null) {
            builder.append(HttpHeaders.ACCEPT).append(": ").append(temp).append(CRLF);
        }
        temp = getAcceptCharsetHeader();
        if(temp != null) {
            builder.append(HttpHeaders.ACCEPT_CHARSET).append(": ").append(temp).append(CRLF);
        }
        temp = getAcceptLanguageHeader();
        if(temp != null) {
            builder.append(HttpHeaders.ACCEPT_LANGUAGE).append(": ").append(temp).append(CRLF);
        }
        temp = getAcceptRangesHeader();
        if(temp != null) {
            builder.append(HttpHeaders.ACCEPT_RANGES).append(": ").append(temp).append(CRLF);
        }
        temp = getAgeHeader();
        if(temp != null) {
            builder.append(HttpHeaders.AGE).append(": ").append(temp).append(CRLF);
        }
        temp = getAllowHeader();
        if(temp != null) {
            builder.append(HttpHeaders.ALLOW).append(": ").append(temp).append(CRLF);
        }
        temp = getAuthorizationHeader();
        if(temp != null) {
            builder.append(HttpHeaders.AUTHORIZATION).append(": ").append(temp).append(CRLF);
        }
        temp = getCacheControlHeader();
        if(temp != null) {
            builder.append(HttpHeaders.CACHE_CONTROL).append(": ").append(temp).append(CRLF);
        }
        temp = getConnectionHeader();
        if(temp != null) {
            builder.append(HttpHeaders.CONNECTION).append(": ").append(temp).append(CRLF);
        }
        temp = getContentLanguageHeader();
        if(temp != null) {
            builder.append(HttpHeaders.CONTENT_LANGUAGE).append(": ").append(temp).append(CRLF);
        }
        temp = getContentLocationHeader();
        if(temp != null) {
            builder.append(HttpHeaders.CONTENT_LOCATION).append(": ").append(temp).append(CRLF);
        }
        temp = getContentMd5Header();
        if(temp != null) {
            builder.append(HttpHeaders.CONTENT_MD5).append(": ").append(temp).append(CRLF);
        }
        temp = getContentRangeHeader();
        if(temp != null) {
            builder.append(HttpHeaders.CONTENT_RANGE).append(": ").append(temp).append(CRLF);
        }
        temp = getContentTypeHeader();
        if(temp != null) {
            builder.append(HttpHeaders.CONTENT_TYPE).append(": ").append(temp).append(CRLF);
        }
        temp = getCookieHeader();
        if(temp != null) {
            builder.append(COOKIE_HEADER).append(": ").append(temp).append(CRLF);
        }
        temp = getDateHeader();
        if(temp != null) {
            builder.append(HttpHeaders.DATE).append(": ").append(temp).append(CRLF);
        }
        temp = getDavHeader();
        if(temp != null) {
            builder.append(HttpHeaders.DAV).append(": ").append(temp).append(CRLF);
        }
        temp = getDepthHeader();
        if(temp != null) {
            builder.append(HttpHeaders.DEPTH).append(": ").append(temp).append(CRLF);
        }
        temp = getDestinationHeader();
        if(temp != null) {
            builder.append(HttpHeaders.DESTINATION).append(": ").append(temp).append(CRLF);
        }
        temp = getETagHeader();
        if(temp != null) {
            builder.append(HttpHeaders.ETAG).append(": ").append(temp).append(CRLF);
        }
        temp = getExpectHeader();
        if(temp != null) {
            builder.append(HttpHeaders.EXPECT).append(": ").append(temp).append(CRLF);
        }
        temp = getExpiresHeader();
        if(temp != null) {
            builder.append(HttpHeaders.EXPIRES).append(": ").append(temp).append(CRLF);
        }
        temp = getFromHeader();
        if(temp != null) {
            builder.append(HttpHeaders.FROM).append(": ").append(temp).append(CRLF);
        }
        temp = getHostHeader();
        if(temp != null) {
            builder.append(HttpHeaders.HOST).append(": ").append(temp).append(CRLF);
        }
        temp = getIfHeader();
        if(temp != null) {
            builder.append(HttpHeaders.IF).append(": ").append(temp).append(CRLF);
        }
        temp = getIfMatchHeader();
        if(temp != null) {
            builder.append(HttpHeaders.IF_MATCH).append(": ").append(temp).append(CRLF);
        }
        temp = getIfModifiedSinceHeader();
        if(temp != null) {
            builder.append(HttpHeaders.IF_MODIFIED_SINCE).append(": ").append(temp).append(CRLF);
        }
        temp = getIfNoneMatchHeader();
        if(temp != null) {
            builder.append(HttpHeaders.IF_NONE_MATCH).append(": ").append(temp).append(CRLF);
        }
        temp = getIfRangeHeader();
        if(temp != null) {
            builder.append(HttpHeaders.IF_RANGE).append(": ").append(temp).append(CRLF);
        }
        temp = getIfUnmodifiedSinceHeader();
        if(temp != null) {
            builder.append(HttpHeaders.IF_UNMODIFIED_SINCE).append(": ").append(temp).append(CRLF);
        }
        temp = getLastModifiedHeader();
        if(temp != null) {
            builder.append(HttpHeaders.LAST_MODIFIED).append(": ").append(temp).append(CRLF);
        }
        temp = getLocationHeader();
        if(temp != null) {
            builder.append(HttpHeaders.LOCATION).append(": ").append(temp).append(CRLF);
        }
        temp = getLockTokenHeader();
        if(temp != null) {
            builder.append(HttpHeaders.LOCK_TOKEN).append(": ").append(temp).append(CRLF);
        }
        temp = getMaxForwardsHeader();
        if(temp != null) {
            builder.append(HttpHeaders.MAX_FORWARDS).append(": ").append(temp).append(CRLF);
        }
        temp = getOverwriteHeader();
        if(temp != null) {
            builder.append(HttpHeaders.OVERWRITE).append(": ").append(temp).append(CRLF);
        }
        temp = getPragmaHeader();
        if(temp != null) {
            builder.append(HttpHeaders.PRAGMA).append(": ").append(temp).append(CRLF);
        }
        temp = getProxyAuthenticateHeader();
        if(temp != null) {
            builder.append(HttpHeaders.PROXY_AUTHENTICATE).append(": ").append(temp).append(CRLF);
        }
        temp = getProxyAuthorizationHeader();
        if(temp != null) {
            builder.append(HttpHeaders.PROXY_AUTHORIZATION).append(": ").append(temp).append(CRLF);
        }
        temp = getRangeHeader();
        if(temp != null) {
            builder.append(HttpHeaders.RANGE).append(": ").append(temp).append(CRLF);
        }
        temp = getRefererHeader();
        if(temp != null) {
            builder.append(HttpHeaders.REFERER).append(": ").append(temp).append(CRLF);
        }
        temp = getRetryAfterHeader();
        if(temp != null) {
            builder.append(HttpHeaders.RETRY_AFTER).append(": ").append(temp).append(CRLF);
        }
        temp = getServerHeader();
        if(temp != null) {
            builder.append(HttpHeaders.SERVER).append(": ").append(temp).append(CRLF);
        }
        temp = getStatusUriHeader();
        if(temp != null) {
            builder.append(HttpHeaders.STATUS_URI).append(": ").append(temp).append(CRLF);
        }
        temp = getTeHeader();
        if(temp != null) {
            builder.append(HttpHeaders.TE).append(": ").append(temp).append(CRLF);
        }
        temp = getTimeoutHeader();
        if(temp != null) {
            builder.append(HttpHeaders.TIMEOUT).append(": ").append(temp).append(CRLF);
        }
        temp = getTrailerHeader();
        hasTrailerHeader = temp != null;
        if(temp != null) {
            builder.append(HttpHeaders.TRAILER).append(": ").append(temp).append(CRLF);
        }
        temp = getTransferEncodingHeader();
        hasChunkedTransferEncoding = HTTP.CHUNK_CODING.equalsIgnoreCase(temp);
        if(temp != null) {
            builder.append(HttpHeaders.TRANSFER_ENCODING).append(": ").append(temp).append(CRLF);
        }
        temp = getUpgradeHeader();
        if(temp != null) {
            builder.append(HttpHeaders.UPGRADE).append(": ").append(temp).append(CRLF);
        }
        temp = getUpgradeInsecureRequestsHeader();
        if(temp != null) {
            builder.append(UPGRADE_INSECURE_REQUESTS_HEADER).append(": ").append(temp).append(CRLF);
        }
        temp = getUserAgentHeader();
        if(temp != null) {
            builder.append(HttpHeaders.USER_AGENT).append(": ").append(temp).append(CRLF);
        }
        temp = getVaryHeader();
        if(temp != null) {
            builder.append(HttpHeaders.VARY).append(": ").append(temp).append(CRLF);
        }
        temp = getViaHeader();
        if(temp != null) {
            builder.append(HttpHeaders.VIA).append(": ").append(temp).append(CRLF);
        }
        temp = getWarningHeader();
        if(temp != null) {
            builder.append(HttpHeaders.WARNING).append(": ").append(temp).append(CRLF);
        }
        temp = getWWWAuthenticateHeader();
        if(temp != null) {
            builder.append(HttpHeaders.WWW_AUTHENTICATE).append(": ").append(temp).append(CRLF);
        }
        // Add the uncommon headers
        Map<String, String> uncommonHeaders = getUncommonHeaders();
        for(String name : uncommonHeaders.keySet()) {
            if(uncommonHeaders.get(name) != null) {
                builder.append(name).append(": ").append(uncommonHeaders.get(name)).append(CRLF);
            }
        }
        // Add the replaced headers
        builder.append(HttpHeaders.ACCEPT_ENCODING).append(": ").append(HTTP.IDENTITY_CODING).append(CRLF);
        builder.append(HttpHeaders.CONTENT_ENCODING).append(": ").append(HTTP.IDENTITY_CODING).append(CRLF);
        return new boolean[]{hasTrailerHeader, hasChunkedTransferEncoding};
    }

    /* Adds this request's content-length header and entity body to the specified StringBuilder. */
    private void addEntityInfo(StringBuilder builder, boolean hasChunkedTransferEncoding) {
        String body = getEntityBody();
        if(hasChunkedTransferEncoding) {
            if(body != null && !body.isEmpty()) {
                int i = 0;
                while(i < body.length()) {
                    int chunkSize = Math.min(body.length() - i, MAX_CHUNK_SIZE);
                    String chunkStr = (chunkSize == MAX_CHUNK_SIZE) ? MAX_CHUNK_STR : Integer.toHexString(chunkSize);
                    builder.append(chunkStr).append("\r\n");
                    for(int j = 0; j < chunkSize; j++, i++) {
                        builder.append(body.charAt(i));
                    }
                    builder.append("\r\n");
                }
            }
            // Add a terminating chunk
            builder.append("0\r\n");
        } else {
            if(body != null) {
                builder.append(HttpHeaders.CONTENT_LENGTH).append(": ").append(body.length()).append(CRLF);
                builder.append(CRLF).append(body);
            } else {
                builder.append(HttpHeaders.CONTENT_LENGTH).append(": ").append("0").append(CRLF).append(CRLF);
            }
        }
    }

    /* Adds trailers for this request to the specified StringBuilder if this request's transfer-encoding is chunked and
     * it has a trailer header. */
    private void addTrailers(StringBuilder builder, boolean hasTrailerHeader, boolean hasChunkedTransferEncoding) {
        Map<String, String> trailers = getTrailers();
        if(hasChunkedTransferEncoding) {
            if(hasTrailerHeader) {
                // Add the trailers
                for(String name : trailers.keySet()) {
                    if(trailers.get(name) != null) {
                        builder.append(name).append(": ").append(trailers.get(name)).append(CRLF);
                    }
                }
            }
            // Add trailer end
            builder.append("\r\n");
        }
    }

    /* Returns a text representation of this request. */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getMethod()).append(' ');
        try {
            addURIInfo(builder);
        } catch(Exception e) {
            builder.append(uri.toASCIIString());
        }
        builder.append(' ').append(getProtocolVersion()).append(CRLF);
        boolean[] temp = addHeaderInfo(builder);
        boolean hasTrailerHeader = temp[0];
        boolean hasChunkedTransferEncoding = temp[1];
        addEntityInfo(builder, hasChunkedTransferEncoding);
        addTrailers(builder, hasTrailerHeader, hasChunkedTransferEncoding);
        return builder.toString();
    }

    /* Returns the field with the specified name and type for the specified object's class or null if the
     * field was not found. */
    private static Field getField(Object obj, String fieldName, Class<?> fieldClass) {
        for(Class<?> clazz = obj.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            // Iterate over superclasses to check for the field
            try {
                Field field = clazz.getDeclaredField(fieldName);
                if(field.getName().equals(fieldName) && fieldClass.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    return field;
                }
            } catch (Exception e) {
                //
            }
        }
        return null;
    }

    /* Reads bytes from the specified channel, structures the read bytes into a PhosphorHttpRequest, converts that
     * request back into bytes, and return a ByteBuffer wrapping those bytes. Returns null if any errors occurred. */
    private static ByteBuffer structureRequestBytes(ByteChannel channel, int bufferLength) throws IOException, URISyntaxException, HttpException {
        PhosphorHttpRequest request = requestFromSocket(channel, bufferLength);
        if(request == null) {
            return null;
        }
        String requestStr = request.toString();
        String untaintedRequestStr = TaintedStringBuilder.taintChars(new String(requestStr.toCharArray()), null);
        synchronized(PhosphorHttpRequest.class) {
            interceptedRequests.add(untaintedRequestStr);
        }
        return ByteBuffer.wrap(requestStr.getBytes());
    }

    /* Reads bytes from the specified channel into a buffer of the specified initial length. Returns a PhosphorHttpRequest
     * parsed from the read bytes. */
    private static PhosphorHttpRequest requestFromSocket(ByteChannel channel, int initialBufferLength) throws IOException, URISyntaxException, HttpException {
        parserMap.putIfAbsent(channel, BufferedHttpMessageParser.getRequestParser());
        BufferedHttpMessageParser<HttpRequest> parser = parserMap.get(channel);
        int nRead = 1;
        while(!parser.hasParsedMessage()) {
            if(nRead < 0) {
                throw new EOFException();
            } else if(nRead == 0) {
                return null;
            }
            byte[] bytes = new byte[initialBufferLength];
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            nRead = channel.read(buf);
            buf.flip();
            parser.appendBytes(buf);
        }
        BufferedHttpMessageParser.ParsedMessage<HttpRequest> parsed = parser.getParsedMessage();
        return new PhosphorHttpRequest(parsed.getMessage(), parsed.getEntity(), parsed.getTrailers());
    }

    /* Reads from the specified Object's phosphor-added buffer into the specified destination buffer. If the phosphor-added
     * is exhausted,reads bytes from the specified ByteChannel until a request can be parsed from them. Parses a request
     * from the read bytes and then refills the specified source buffer with those bytes. Returns the number of bytes read
     * into the destination buffer. */
    public static int read(ByteChannel channel, ByteBuffer dest, Object obj) {
        try {
            Field bufField = getField(obj, RestructureRequestBytesCV.BYTE_BUFF_FIELD_NAME, ByteBuffer.class);
            if(bufField == null) {
                throw new IllegalStateException("Expected ByteBuffer field to be added by Phosphor to store the restructured bytes");
            }
            ByteBuffer source = (ByteBuffer) bufField.get(obj);
            if(source == null || !source.hasRemaining()) {
                int bufferLength = dest.capacity();
                source = PhosphorHttpRequest.structureRequestBytes(channel, bufferLength);
                bufField.set(obj, source);
            }
            if(source == null) {
                return 0;
            }
            int nRead = Math.min(source.remaining(), dest.remaining());
            if(nRead > 0) {
                dest.put(source.array(), source.arrayOffset() + source.position(), nRead);
                source.position(source.position() + nRead);
            }
            return nRead;
        } catch(EOFException e) {
            return -1;
        } catch(Exception e) {
            return 0;
        }
    }

    public static long read(ByteChannel channel, ByteBuffer[] dests, int offset, int length, Object obj) {
        if((offset < 0) || (length < 0) || (offset > dests.length - length)) {
            throw new IndexOutOfBoundsException();
        }
        try {
            Field bufField = getField(obj, RestructureRequestBytesCV.BYTE_BUFF_FIELD_NAME, ByteBuffer.class);
            if(bufField == null) {
                throw new IllegalStateException("Expected ByteBuffer field to be added by Phosphor to store the restructured bytes");
            }
            ByteBuffer source = (ByteBuffer) bufField.get(obj);
            if(source == null || !source.hasRemaining()) {
                int bufferLength = dests[offset].capacity();
                source = PhosphorHttpRequest.structureRequestBytes(channel, bufferLength);
                bufField.set(obj, source);
            }
            if(source == null) {
                return 0;
            }
            int totalRead = 0;
            while(source.hasRemaining() && offset < offset + length) {
                int nRead = Math.min(source.remaining(), dests[offset].remaining());
                if(nRead > 0) {
                    dests[offset].put(source.array(), source.arrayOffset() + source.position(), nRead);
                    source.position(source.position() + nRead);
                }
                totalRead += nRead;
            }
            return totalRead;
        } catch(EOFException e) {
            return -1;
        } catch(Exception e) {
            return 0;
        }
    }

    /* Creates a copy of interceptedRequests and then clears interceptedRequests. Returns the copy. */
    public static synchronized LinkedList<String> getAndClearInterceptedRequests() {
        LinkedList<String> copy = new LinkedList<>(interceptedRequests);
        interceptedRequests.clear();
        return copy;
    }

    /* Clears interceptedRequests. */
    public static synchronized void clearInterceptedRequests() {
        interceptedRequests.clear();
    }
}
