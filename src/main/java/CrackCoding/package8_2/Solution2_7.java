package CrackCoding.package8_2;

/**
 * Created by liyuan on 2017/7/18.
 */

import java.util.Stack;

/**编写一个函数检查链表是否为回文*/
public class Solution2_7 {

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(3);
        ListNode node10 = new ListNode(2);
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(0);
 //       ListNode node13 = new ListNode(1);

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
    //    node12.next = node13;
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode fast = pHead;
        ListNode slow = pHead;
        Stack<Integer> stack = new Stack();
        while(fast!=null && fast.next!=null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        //链表有奇数个结点。跳过中间元素
        if (fast!=null){
            slow = slow.next;
        }

        while(slow!=null){
            if (stack.pop()!=slow.val)
                return false;
            slow=slow.next;
        }
        return true;
    }

}
