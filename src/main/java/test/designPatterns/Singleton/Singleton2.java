package test.designPatterns.Singleton;

/**
 * Created by liyuan on 2017/7/11.
 */

//懒汉式

    /*
    * 1、类加载时，不实例化对象，避免了资源的浪费
    * 2、线程不安全，仅适用于单线程
    * */
public class Singleton2 {

    private Singleton2(){}
    private static Singleton2 instance = null;

    public static Singleton2 getInstance(){
        if (instance==null)
            instance = new Singleton2();
        return instance;

    }

}
