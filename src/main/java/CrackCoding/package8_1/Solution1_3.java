package CrackCoding.package8_1;

/**
 * Created by liyuan on 2017/6/6.
 */

import java.util.HashMap;
import java.util.Set;

/**给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串*/
public class Solution1_3 {

    //使用HashMap
    public static boolean isSame(String s1, String s2){
        if (s1.length()!=s2.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        for (Character c: s1Array
             ) {
            if (map1.containsKey(c))
                map1.put(c,map1.get(c)+1);
            else
                map1.put(c ,1);
        }

        for (Character c: s2Array
             ) {
            if (map2.containsKey(c))
                map2.put(c,map2.get(c)+1);
            else
                map2.put(c,1);
        }

        if (map1.size()!=map2.size()) return false;

        Set<Character> keySet = map1.keySet();

        for (Character c: keySet
             ) {
            if (!map2.containsKey(c)) {
                return false;
            }else if (map1.get(c)!=map2.get(c)){

                return false;
            }

        }
        return true;
    }

    //使用数组，假设字符集为ASCII，则一共有256个字符集
    public static boolean isSame2(String s1,String s2){
        if (s1.length()!=s2.length())
            return false;

        int[] numbers = new int[256];

        char[] s1Array = s1.toCharArray();
        for (Character c: s1Array
             ) {
            numbers[c]++;
        }


        for (int i = 0; i < s2.length(); i++) {
            int c =(int) s2.charAt(i);
            if (--numbers[c]<0) {
                return false;
            }
        }



        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSame("abc", "abc"));
        System.out.println(isSame2("abca", "abcd"));
    }
}
