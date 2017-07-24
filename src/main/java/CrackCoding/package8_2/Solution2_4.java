package CrackCoding.package8_2;

/**
 * Created by liyuan on 2017/7/10.
 */

/**编写代码给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前*/
public class Solution2_4 {
    public static LinkedListNode partition(LinkedListNode node ,int x){
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;

        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(node!=null){
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data<x) {
                if (beforeStart==null){
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }

            }else{
                if (afterStart==null){
                    afterStart = node;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;

        }

        if (beforeStart==null)
            return afterStart;
        //合并before和after
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
