package leetcode;

/**
 * Created by liyuan on 2017/8/23.
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
Sort a linked list in O(n log n) time using constant space complexity.
*/
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null|| head.next==null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);

        ListNode temp_head = new ListNode(0);
        ListNode temp_node = temp_head;
        while(left!=null&&right!=null){
            if (left.val < right.val){

                temp_node.next = left;
                left = left.next;
            }

            else{
                temp_node.next = right;
                right = right.next;
            }
            temp_node = temp_node.next;

        }

        if (left!=null)
            temp_node.next = left;
        if (right!=null)
            temp_node.next = right;
        return temp_head.next;


    }
}
