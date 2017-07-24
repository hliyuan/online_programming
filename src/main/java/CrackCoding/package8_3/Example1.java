package CrackCoding.package8_3;

/**
 * Created by liyuan on 2017/7/18.
 */

//用链表实现一个栈
public class Example1 {

    ListNode top;

    Object pop(){
        if (top != null) {
            Object item = top.val;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(Object item){
        ListNode t = new ListNode(item);
        t.next = top;
        top = t;
    }

    Object peek(){
        return top.val;
    }


}
