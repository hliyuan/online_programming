package CrackCoding.package8_3;

/**
 * Created by liyuan on 2017/7/19.
 */



import java.util.Stack;

/**设计一个栈，除pop与push方法外，还支持min方法，可返回栈元素中的最小值。push,pop和min三个方法的时间复杂度必须为O(1)。*/
public class Solution3_2 extends Stack {
    Stack<Integer> stack;
    public Solution3_2(){
        stack = new Stack<Integer>();
    }

    public void push(int value){
        if (value<= min()){
            stack.push(value);
        }
        super.push(value);
    }

    

    public Integer pop(){
        int value = Integer.parseInt(String.valueOf(super.pop()));
        if (value == min()){
            stack.pop();
        }
        return value;
    }

    public int min(){
        if (stack.empty()){
            return Integer.MAX_VALUE;
        }else {
            return stack.peek();
        }
    }

}
