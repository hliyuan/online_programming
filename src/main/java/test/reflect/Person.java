package test.reflect;

/**
 * Created by liyuan on 2017/6/7.
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        super();
        System.out.println("person run...");
    }
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
        System.out.println("person param run......"+this.name+":"+this.age);
    }

    public void show() {
        System.out.println("show run..."+name+":"+age);
    }

    private void privateMethod(){
        System.out.println("method run");
    }

    public void paramMethod(String str, int num){
        System.out.println("paramMethod run..."+str+":"+num);
    }

    public static void staticMethod() {
        System.out.println("staticMethod run...");
    }

}
