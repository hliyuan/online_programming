package test.Proxy.staticProxy;

import test.Proxy.RealSubject;
import test.Proxy.Subject;

/**
 * Created by liyuan on 2017/8/28.
 */
public class ProxySubject implements Subject {
    RealSubject realSubject = new RealSubject();

    public void doSomething() {
        System.out.println("before");
        realSubject.doSomething();
        System.out.println("after");
    }
}
