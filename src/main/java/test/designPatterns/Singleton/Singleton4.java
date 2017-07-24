package test.designPatterns.Singleton;

/**
 * Created by liyuan on 2017/7/11.
 */

//改进2-双重检查锁
    /*
    * 1、加入volatile，禁止指令重排序。
    * 2、该方法兼顾线程安全和性能。
    * */
public class Singleton4 {
    private Singleton4(){}
    private  static volatile Singleton4 instance = null;

    public static Singleton4 getInstance(){
        if (instance==null){
            synchronized(Singleton4.class) {
                if (instance==null)
                    instance = new Singleton4();
            }
        }
        return instance;
    }
}
