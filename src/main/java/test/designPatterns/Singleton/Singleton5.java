package test.designPatterns.Singleton;

/**
 * Created by liyuan on 2017/7/12.
 */
//静态内部类
public class Singleton5 {
    private Singleton5(){}
    private static class Single{
        public static Singleton5 instance = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return Single.instance;
    }
}
