package test.TestMap;

/**
 * Created by liyuan on 2017/8/15.
 */
public class TestStaticInnerClass {

    private TestStaticInnerClass(){}

    static class TestInner{

        public static final TestStaticInnerClass test = new TestStaticInnerClass();
    }

    public static TestStaticInnerClass getTestStaticInnerClass(){
        return TestInner.test;
    }

    //普通内部类不能声明静态方法和变量（常量可以static final）
    //静态内部类形似外部类，没有任何限制。
    class TestUsual{
        public static final int i = 0;
    }

    public static void main(String[] args) {
        TestStaticInnerClass test1 = TestStaticInnerClass.getTestStaticInnerClass();
        TestStaticInnerClass test2 = TestStaticInnerClass.getTestStaticInnerClass();
//        TestInner.test = new TestStaticInnerClass();
        TestStaticInnerClass test3 = TestStaticInnerClass.getTestStaticInnerClass();

        System.out.println(test1.equals(test2));

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }
}
