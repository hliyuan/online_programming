package CrackCoding.package8_1;

/**
 * Created by liyuan on 2017/6/5.
 */

import java.util.HashMap;
import java.util.Set;

/**
 * 实现一个算法，确定一个字符串的所有字符是否全都不同。假设不允许使用额外的数据结构，又该如何处理？
 * */
public class Solution1_1 {

    //方案一、使用额外的数据结构HashMap解决
    public static boolean isNotAllSame1(String s1){

        HashMap<Character,Integer> map1 = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) {
            if (map1.containsKey(s1.charAt(i)))
                return false;
            else
                map1.put(s1.charAt(i),1);
        }

        return true;
    }

    //方案二、不使用额外的数据结构
    //假设字符集为ASCII码，则字母表只有256个字符
    public static boolean isNotAllSame2(String s1){
        if (s1.length()>256) return false;

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < s1.length(); i++) {
            int val = s1.charAt(i);
            System.out.println("2: "+val);
            if (char_set[val])
                return false;
            char_set[val] = true;
        }
        return true;

    }

    //假设字符串为a到z的26个小写字母
    public static boolean isNotAllSame3(String s){

        if (s.length()>26) return  false;

        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i)-'a';

            if ((checker & (1<<val))>0)
                return false;
            checker |= (1<<val);
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(isNotAllSame1("abcc"));
        System.out.println(isNotAllSame2("abc"));
        System.out.println(isNotAllSame3("abc"));

    }
}
