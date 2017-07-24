package test.reflectDemo;

/**
 * Created by liyuan on 2017/6/8.
 */
public class SoundCard implements PCI {

    public void open() {
        System.out.println("sound card run......");
    }

    public void close() {
        System.out.println("sound card close......");
    }
}
