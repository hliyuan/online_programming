package CrackCoding.package8_3;

/**
 * Created by liyuan on 2017/7/20.
 */

/**设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们会另外堆一堆盘子。
 * 请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时，新建一个栈。
 * 此外，SetOfStacks.oush()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样。）*/

import java.util.ArrayList;
import java.util.Stack;

/**进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作*/
public class Solution3_3 {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    int capacity = 100;
    public void push(int v){
        Stack last = getLastStack();
        if (last != null ){   //  if(last!=null && last.isFull())
            last.push(v);
        }else {
            Stack stack = new Stack();
            stack.push(v);
            stacks.add(stack);
        }
    }



    private Stack getLastStack() {
        return null;
    }
    public int pop(){
        Stack last = getLastStack();
        int v = Integer.parseInt(String.valueOf(last.pop()));
        if (last.size()==0)
            stacks.remove(stacks.size()-1);
        return v;
    }

}
