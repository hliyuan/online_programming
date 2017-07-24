package test.reflectDemo;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

/**
 * Created by liyuan on 2017/6/8.
 */
public class ReflectTest {

    /**
     * 电脑运行
     * */
    public static void main(String[] args) throws Exception {

        MainBoard mainBoard = new MainBoard();
        mainBoard.run();


        //扩展应用，读取配置文件
        File configFile = new File("src\\main\\java\\test\\reflectDemo\\pci.properities");

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(configFile);

        prop.load(fis);      //将流数据加载到集合中

        for (int i = 0; i < prop.size(); i++) {

            String className = prop.getProperty("pci"+(i+1));

            Class clazz = Class.forName(className);

            PCI p =(PCI) clazz.newInstance();

            p.open();

        }


/*        FileInputStream inputStream;
        ClassLoader cl = XXX. class .getClassLoader();
        if  (cl !=  null ) {
            inputStream = cl.getResourceAsStream( "xx.properties" );
        }  else {
            inputStream = ClassLoader.getSystemResourceAsStream( "xx.properties" );
        }*/

    }
}
