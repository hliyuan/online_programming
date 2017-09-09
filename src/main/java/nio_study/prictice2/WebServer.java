package nio_study.prictice2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by liyuan on 2017/9/7.
 */
public class WebServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1",8080));

            SocketChannel socketChannel = ssc.accept();

            ByteBuffer readBuffer = ByteBuffer.allocate(128);

            socketChannel.read(readBuffer);

            readBuffer.flip();

            while (readBuffer.hasRemaining()){
                System.out.println((char) readBuffer.get());
            }

            socketChannel.close();
            ssc.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
