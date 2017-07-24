package multiThread.chapter1;

/**
 * Created by liyuan on 2017/6/19.
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否停止1？=" + thread.currentThread().getName() + thread.interrupted());
            System.out.println("是否停止2？=" + thread.currentThread().getName() + thread.interrupted());
            System.out.println("是否停止3？=" + thread.getName() + thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");

    }
}
