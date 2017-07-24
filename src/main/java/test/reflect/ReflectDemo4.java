package test.reflect;

/**
 * Created by liyuan on 2017/6/8.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 获取指定Class文件的方法。
 * */
public class ReflectDemo4 {

    public static void main(String[] args) throws Exception {
        getMethodDemo_1();
        getMethodDemo_2();
        getMethodDemo_3();
    }


    /**
     * 获取指定Class中的所有公有函数
     * */
    public static void getMethodDemo_1() throws ClassNotFoundException {

        Class clazz = Class.forName("test.reflect.Person");

        Method[] methods = clazz.getMethods(); //获取的都是公有的方法。

        for (Method method : methods) {

            System.out.println(method);     //打印：public void test.reflect.Person.paramMethod(java.lang.String,int)
                                              //public static void test.reflect.Person.staticMethod()
                                              //public void test.reflect.Person.show(int)
        }

        //methods = clazz.getDeclaredMethods();  //若想获取本类中所有方法，包含私有。需要强制访问。setAccessible(true);

    }

    /**
     * 获取无参方法。
     * */
    public static void getMethodDemo_2() throws Exception {

        Class clazz = Class.forName("test.reflect.Person");

        Method method = clazz.getMethod("show",null); //获取指定方法，必须要指定方法名。空参数。

        //Object obj = clazz.newInstance();

        Constructor constructor = clazz.getConstructor(String.class, int.class);

        Object obj = constructor.newInstance("baobao",25);

        method.invoke(obj,null);
        //person param run......baobao:25
        //show run...baobao:25

    }

    /**
     * 获取有参数方法。
     * */
    public static void getMethodDemo_3() throws Exception {

        Class clazz = Class.forName("test.reflect.Person");

        Method method = clazz.getMethod("paramMethod", String.class, int.class); //获取指定方法，必须要指定方法名。空参数。

        Object obj = clazz.newInstance();

        method.invoke(obj,"daidai",25);
        //person run...
        //paramMethod run...daidai:25
    }



}
