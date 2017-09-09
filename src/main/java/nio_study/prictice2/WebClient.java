package nio_study.prictice2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by liyuan on 2017/9/7.
 */
public class WebClient {

    public static void main(String[] args) {
/*

        SocketChannel socketChannel = null;

        try {
            socketChannel = SocketChannel.open();

            socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));

            ByteBuffer writeBuffer = ByteBuffer.allocate(128);

            writeBuffer.put("hello world".getBytes());

            writeBuffer.flip();

            socketChannel.write(writeBuffer);

            socketChannel.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            ByteBuffer buffer2 = ByteBuffer.allocate(16);
            writeBuffer.put("hello ".getBytes());
            buffer2.put("world".getBytes());

            writeBuffer.flip();
            buffer2.flip();
            ByteBuffer[] bufferArray = {writeBuffer, buffer2};
            socketChannel.write(bufferArray);
            socketChannel.close();
        } catch (IOException e) {
        }


    }
}
