package test.reflect;

import java.lang.reflect.Field;

/**
 * Created by liyuan on 2017/6/8.
 */

/**
 * 获取指定Class的字段
 * */
public class ReflectDemo3 {

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        getFieldDemo();
    }

    public static void getFieldDemo() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class clazz = Class.forName("test.reflect.Person");


        //Field field = clazz.getField("age");  //getField只能获取公共字段，
        //System.out.println(field);      //NoSuchFieldException异常

        Field field = clazz.getDeclaredField("age");  //获取本类的字段，包括私有、保护、公有。

        //Object obj = clazz.newInstance();
        //Object o = field.get(obj);      //get(Object obj)  属性(字段)只能由对象调用。
        //System.out.println(o);   //IllegalAccessException,无效的访问异常，因为成员是私有的


        /**
         * 那么如何访问私有字段呢？---取消权限检查、强制访问，不建议使用。
         * setAcessible(true);
         * */

        field.setAccessible(true);
        Object obj2 = clazz.newInstance();
        field.set(obj2,25);
        Object o2 = field.get(obj2);
        System.out.println(o2);  //25

    }
}
