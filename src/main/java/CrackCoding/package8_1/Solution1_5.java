package CrackCoding.package8_1;

/**
 * Created by liyuan on 2017/6/6.
 */

import java.util.ArrayList;

/**
 * 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”会变成“a2b1c5a3”.
 * 若压缩后字符串没有变短，则返回原先的字符中。
 * */
public class Solution1_5 {
    
    public static String pressString(String s){
        int length = s.length();
        char[] sArray = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();


        char last = sArray[0];
        int count = 1;
        for (int i = 1; i < sArray.length; i++) {
            if (sArray[i] == last)
                count++;
            else {
                stringBuffer.append(last);
                stringBuffer.append(count);
                last = sArray[i];
                count =1;
            }
        }

        stringBuffer.append(last);
        stringBuffer.append(count);

        if (length > stringBuffer.length())
            return stringBuffer.toString();
        else
            return s;
    }

    public static void main(String[] args) {
        System.out.println(pressString("aabcccccaaa"));
        System.out.println(pressString("abcdddddddd"));
    }
}
