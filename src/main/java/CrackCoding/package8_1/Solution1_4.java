package CrackCoding.package8_1;

/**
 * Created by liyuan on 2017/6/6.
 */

/**
 * 编写一个方法，将字符串中的空格全部替换成“%20”。假定该字符串尾部有足够的的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用java实现的话，请使用字符数组实现，以便直接在数组上操作）
 * 示例
 * 输入：“Mr John Smith”
 * 输出：“Mr%20John%20Smith”
 * */
public class Solution1_4 {

    public static String replaceSpace(String s){
        char[] c = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            if (c[i]==' ') stringBuffer.append("%20");
            else stringBuffer.append(c[i]);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("Mr John Smith"));
    }
}
