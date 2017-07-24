package CrackCoding.package8_1;

/**
 * Created by liyuan on 2017/6/7.
 */
/**
 * 假定有一个方法isSubstring，可检查一个单词是否为其他字符串的子串。给定两个字符串s1和s2,请编写代码检查s2是否为s1旋转而成，
 * 要求只能再调用一次isSubstring。（比如，waterbottle是erbottlewat旋转后的字符串）
 * */


public class Solution1_8 {

    /*
    * 假定s2由s1旋转而成，那么我们需要找到旋转点在哪。
    * 例如：若以wat对waterbottle旋转，就会得到erbottlewat。在旋转字符串时，我们会把s1切分成两部分：x和y.并将它重新组合成s2.
    * s1 = xy = waterbottle
    * x = wat
    * y = erbottle
    * s2 = yx = erbottlewat
    *因此，我们需要确认有没有办法将s1切分成x和y.以满足 xy = s1和 yx = s2.
    * 不论x和y的切分点在哪，我们都会发现yx肯定是xyxy的子串。即s2是s1s1的子串。
    * */
    public static boolean isRotation(String s1, String s2){
        if (s1.length()==s2.length()&&s1.length()>0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);

        }
        return false;
    }

    public static boolean isSubstring(String s1, String s2) {
        return true;
    }

}
