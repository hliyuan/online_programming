package test.designPatterns.Singleton;

/**
 * Created by liyuan on 2017/7/11.
 */

//饿汉式
    /*
    * 1、线程安全
    * 2、类加载时实例化对象，浪费系统资源。
    * */
public class Singleton1 {
    private  Singleton1(){}
    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance(){
        return instance;
    }


}
