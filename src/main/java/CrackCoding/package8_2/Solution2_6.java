package CrackCoding.package8_2;

/**
 * Created by liyuan on 2017/7/12.
 */
/**给定一个有环链表，实现一个算法返回环路的开头结点*/

/*
* 1、FastPoint的移动速度是SlowPoint的两倍，当SlowPointer走了k个结点进入环路时，FastPointer已进入链表环路k个结点。
* 也就是说FastPointer和SlowPointer相距LOOP_SIZE-k个结点。
* 2、接下来，若SlowPointer每走一个节点，FastPointer就走两个结点，每走一次，两者的距离就会更近一个结点。因此，在走了LOOP_SIZE-k步后，
* 他们就会碰撞在一起，这时两者距离环路起始处有k个结点。
* 3、链表首部与环路起始处刚好也相距k个结点。因此若其中一个指针保持不变，另一个指针指向链表首部，则两个指针就会在环路起始处想会。
*
* */
public class Solution2_6 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);
        ListNode node13 = new ListNode(13);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;
//        node13.next = node1;





        ListNode collisionSpot = findCollisionSpot(head);

        if (collisionSpot==null)
            System.out.println(false);
        else {
            ListNode beginningSpot = findBeginning(head, collisionSpot);

            System.out.println(beginningSpot.val);

        }
    }

    private static ListNode findCollisionSpot(ListNode head) {
        ListNode fastRunner = head;
        ListNode slowRunner = head;
        while(fastRunner!=null && fastRunner.next!=null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if (slowRunner == fastRunner)
                return slowRunner;

        }
        return null;
    }

    private static ListNode findBeginning(ListNode head, ListNode collisionSpot) {
        ListNode slow = head;
        while (slow != collisionSpot){
            slow = slow.next;
            collisionSpot = collisionSpot.next;
        }
        return slow;
    }


}
