package io.rivulet.maven.test.wavsep;

import io.rivulet.fuzz.Sink;
import io.rivulet.fuzz.Source;

@Source(method = "io/rivulet/PhosphorHttpRequest.getEncodedQuery()Ljava/lang/String;")
@Sink(method = "java/nio/channels/SocketChannel.write(Ljava/nio/ByteBuffer;)I")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;II)J")
@Sink(method = "java/nio/channels/SocketChannel.write([Ljava/nio/ByteBuffer;)J")
public class WavsepXssGetTest extends WavsepXssGenericTest {

    public WavsepXssGetTest() {
        super(WavsepPath.RXSS_GET, WavsepPath.RXSS_GET_EXPERIMENTAL, false);
    }
}
