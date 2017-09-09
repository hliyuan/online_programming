package test.Proxy;

import test.Proxy.dynamicProxy.DynamicProxy;
import test.Proxy.staticProxy.ProxySubject;

/**
 * Created by liyuan on 2017/8/28.
 */
public class Test {

    public static void main(String[] args) {

        //测试静态代理
        Subject sub = new ProxySubject();
        sub.doSomething();

        //测试动态代理
        DynamicProxy dynamicProxy = new DynamicProxy();
        Subject dysub = (Subject) dynamicProxy.bind(new RealSubject());
        dysub.doSomething();
    }

}
