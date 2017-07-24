package multiThread.chapter1;

/**
 * Created by liyuan on 2017/6/19.
 */
public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1？=" + Thread.interrupted());
        System.out.println("是否停止2？=" + Thread.interrupted());
        System.out.println("end!");
    }
}
