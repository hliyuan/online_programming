package test.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by liyuan on 2017/8/23.
 */
public class SortList {

    public static void main(String[] args) {
/*
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(2);
        list.add(3);
        list.add(15);
        list.add(45);
        list.add(4);
        list.add(10);
        list.add(0);*/


        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {

            list.add("abc"+Math.random());
        }


        System.out.println(list);


        Collections.sort(list,new MyComprator());



        System.out.println(list);
    }
    static class MyComprator implements Comparator<String>{

        public int compare(String o1, String o2) {
            if (o1.compareTo(o2)>0)
                return -1;
            else
                return 1;
        }
    }
}
