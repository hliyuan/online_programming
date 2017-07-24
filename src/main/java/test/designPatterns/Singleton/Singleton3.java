package test.designPatterns.Singleton;

/**
 * Created by liyuan on 2017/7/11.
 */

//改进1-引入synchronized

    /*
    * 1、线程安全
    * 2、线程阻塞、切换带来不必要的开销，导致系统性能下降。
    * */
public class Singleton3 {
    private Singleton3(){}
    private static Singleton3 instance =null;

    synchronized public static Singleton3 getInstance(){
        if (instance == null)
            instance = new Singleton3();
        return instance;
    }


}
