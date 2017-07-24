package multiThread.chapter1;

/**
 * Created by liyuan on 2017/6/19.
 */
public class MyThread extends  Thread {

    @Override
    public void run(){
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i="+(i+1));
        }
    }

}
