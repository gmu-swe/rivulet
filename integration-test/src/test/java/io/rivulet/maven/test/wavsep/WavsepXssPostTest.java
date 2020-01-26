package io.rivulet.maven.test.wavsep;

import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;

import static io.rivulet.maven.test.wavsep.WavsepPath.RXSS_POST;
import static io.rivulet.maven.test.wavsep.WavsepPath.RXSS_POST_EXPERIMENTAL;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class WavsepXssPostTest extends WavsepXssGenericTest {

    public WavsepXssPostTest() {
        super(RXSS_POST, RXSS_POST_EXPERIMENTAL, true);
    }
}

