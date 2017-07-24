package test.reflectDemo;

/**
 * Created by liyuan on 2017/6/8.
 */
public class NetCard implements PCI {
    public void open() {
        System.out.println("net card run ....");
    }

    public void close() {
        System.out.println("net card close ....");
    }
}
