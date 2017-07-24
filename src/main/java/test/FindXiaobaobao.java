package test;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by liyuan on 2017/6/6.
 */
public class FindXiaobaobao {
    //抛出异常
    public static Xiaobaobao findXiaobaobao() throws XiaobaobaoNotFoundException{

        Xiaobaobao xiaobaobao = new Xiaobaobao();
        if (xiaobaobao.getName()==null&&xiaobaobao.getAge()==null&&xiaobaobao.getSex()==null)
            throw new XiaobaobaoNotFoundException();
        return xiaobaobao;
    }

    //处理异常
    public static Xiaobaobao getXiaobaobao(){

        try{
            Xiaobaobao xiaobaobao = findXiaobaobao();
            return xiaobaobao;

        }catch (XiaobaobaoNotFoundException e){
            Xiaobaobao xiaobaobao = new Xiaobaobao("daidai","boy","25");
            return xiaobaobao;
        }

    }

    public static void main(String[] args) {
        System.out.println(getXiaobaobao().getName());

    }

}
