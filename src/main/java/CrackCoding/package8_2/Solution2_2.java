package CrackCoding.package8_2;

/**
 * Created by liyuan on 2017/7/10.
 */

/**实现一个算法，找出单向链表中倒数第k个结点*/
public class Solution2_2 {

    //迭代法，一个指针先走k步后，两个指针同时走。
    public static LinkedListNode findK(int k, LinkedListNode head){
        LinkedListNode first = head;
        LinkedListNode second = head;
        while(k--!=1){
            if (second == null) return null;
            second = second.next;
        }
        if (second==null) return null;
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        return first;

    }


    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        LinkedListNode node1 = new LinkedListNode(2);
        LinkedListNode node2 = new LinkedListNode(3);
        LinkedListNode node3 = new LinkedListNode(2);
        LinkedListNode node4 = new LinkedListNode(2);
        LinkedListNode node5 = new LinkedListNode(5);

        head.next = node1;
        node1.next=node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(findK(3, head).data);

    }
}
