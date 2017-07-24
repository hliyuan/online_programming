package CrackCoding.package8_1;

import java.util.Stack;

/**
 * Created by liyuan on 2017/6/5.
 */
public class Solution1_2 {
    /**用C或C++实现void reverse(char* str)函数，即反转一个null结尾的字符串*/

    //java实现
    //方法一：数组实现，遍历全部字符
    public static String reverse1(String s){
        char[] sArray = s.toCharArray();
        int l = sArray.length;
        char[] newS = new char[l];
        for (int i = l-1; i >= 0; i--) {
            newS[l-i-1] = sArray[i];
        }
        return new String(newS);
    }

    //方法二、数组实现、遍历一半字符
    public static String reverse2(String s){
        char[] sArray = s.toCharArray();
        int l = sArray.length;
        for (int i = 0; i < (l-1)/2; i++) {
            char temp = sArray[i];
            sArray[i] = sArray[l-i-1];
            sArray[l-i-1] = temp;
        }
        return new String(sArray);
    }

    //方法三、StringBuffer实现
    public static String reverse3(String s){

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = s.length()-1; i >= 0; i--) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }

    //方法四、栈的实现
    public static String reverse4(String s){

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        char[] newS = new char[s.length()];
        for (int i = 0; i < newS.length; i++) {
            newS[i] = stack.pop();
        }
        return new String(newS);
    }

    //方法五、使用位操作---异或（使用异或交换两个字符的位置）
    public static String reverse5(String s){

        char[] sArray = s.toCharArray();

        int l = sArray.length;
        for (int i = 0; i < (l-1)/2; i++) {
            sArray[i] ^= sArray[l-i-1];
            sArray[l-i-1] ^= sArray[i];
            sArray[i] ^= sArray[l-i-1];

        }
        return new String(sArray);

    }

    public static void main(String[] args) {
        System.out.println(reverse1("abcd"));
        System.out.println(reverse2("abcd"));
        System.out.println(reverse3("abcd"));
        System.out.println(reverse4("abcd"));
        System.out.println(reverse5("abcd"));

    }

}
