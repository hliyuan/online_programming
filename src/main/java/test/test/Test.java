package test.test;


/**
 * Created by liyuan on 2017/8/14.
 */
public class Test {
    static {
        i = 0;
 //       System.out.println(i);
    }

    public static int i = 1;

    public static int c = 0;
    public static final  int value = 3;


    public static void main(String[] args) {
        System.out.println(Test.i);
        testInterface testInterface = new Test1();

    }

}
