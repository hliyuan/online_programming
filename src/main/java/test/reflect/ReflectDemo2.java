package test.reflect;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by liyuan on 2017/6/8.
 */
/**
 * 获取指定Class的构造函数
 * */
public class ReflectDemo2 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        createNewObject_1();
        createNewObject_2();
    }

    public static void createNewObject_1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //早期:new的时候，先根据被new的类的名称找寻该该类的字节码文件，并加载进内存。
        //并创建该字节码文件对象，并接着创建该字节文件的对应的Person对象。
        Person p = new Person();

        //现在
        String name = "test.reflect.Person";
        //找寻该名称类文件，并加载进内存，并产生class对象
        Class clazz = Class.forName(name);
        //如何产生该类的对象呢？
        Object obj = clazz.newInstance();

    }

    public static void createNewObject_2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //早期：通过带参构造函数定义一个实例
        Person p = new Person("baobao",25);


        /**
         * 由于newInstance()方法默认调用无参构造函数。
         * 当要获取指定名称对应类中所体现的对象时，
         * 而该对象初始化 不使用 空参构造函数，该怎么办？
         * 既然是通过指定的构造函数进行对象的初始化，
         * 所以，应该先获取该指定的构造函数。通过字节码文件即可获得。
         * getConstructor(paramterTypes)
         * */
        //现在
        String name = "test.reflect.Person";
        //找寻该名称类文件，并加载进内存，并产生class对象
        Class clazz = Class.forName(name);
        //获取了指定的构造函数对象。
        Constructor constructor = clazz.getConstructor(String.class, int.class);

        //获取全部的公共构造函数
        Constructor []constructors = clazz.getConstructors();
        //获取全部的构造函数，包括私有和保护的
        Constructor []constructors1 = clazz.getDeclaredConstructors();
        //通过该构造器对象的newInstance方法进行对象的实例化
        Object obj = constructor.newInstance("daidai",25);

    }
}
