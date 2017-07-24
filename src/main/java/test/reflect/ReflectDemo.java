package test.reflect;

/**
 * Created by liyuan on 2017/6/7.
 */

/**
 *获取Class对象的三种方式
 * */
public class ReflectDemo {

    public static void getClassObject_1(){
        Person p1 = new Person();
        Class clazz1 = p1.getClass();

        Person p2 = new Person();
        Class clazz2 = p2.getClass();

        System.out.println((clazz1 == clazz2));  //打印true
    }

    public static void getClassObject_2(){

        Class clazz1 = Person.class;

        Class clazz2 = Person.class;

        System.out.println((clazz1 == clazz2));  //打印true
    }

    public static void getClassObject_3() throws ClassNotFoundException {

        String className = "test.reflect.Person";

        Class clazz1 = Class.forName(className);


        System.out.println(clazz1);  //打印true
    }


    public static void main(String[] args) throws ClassNotFoundException {
        getClassObject_1();
        getClassObject_2();
        getClassObject_3();
    }
}
