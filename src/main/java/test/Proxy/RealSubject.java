package test.Proxy;

/**
 * Created by liyuan on 2017/8/28.
 */
public class RealSubject implements Subject {
    public void doSomething() {
        System.out.println("do something");
    }
}
