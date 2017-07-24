package CrackCoding.package8_3;

/**
 * Created by liyuan on 2017/7/18.
 */

//用链表实现一个队列。
public class Example2 {
    ListNode first,last;

    void enqueue(Object item){
        if (first==null){
            last = new ListNode(item);
            first = last;
        }else{

            ListNode t = new ListNode(item);
            last.next = t;
            last = t;
        }
    }

    Object dequeue(){

        if (first!=null){
            Object item = first.val;
            first = first.next;
            return item;
        }
        return null;

    }
}
