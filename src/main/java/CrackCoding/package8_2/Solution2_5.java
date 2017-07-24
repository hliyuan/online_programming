package CrackCoding.package8_2;

/**
 * Created by liyuan on 2017/7/11.
 */

/**给定两个用链表表示的整数，每个节点包含一个数位。这些数位是反向存放的，也就是个位排在链表首部。编写函数对这两个整数求和，并用链表形式返回结果。*/
public class Solution2_5 {


    //数位反向存放，即个位排在链表首部
    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode result = new ListNode(-1);
        ListNode current = result;
        int plus = 0;
        while(a!=null || b!=null|| plus !=0){
            int aVal = a != null ? a.val : 0 ;
            int bVal = b != null ? b.val : 0 ;

            int sum = aVal + bVal +plus;

            int nodeVal = sum % 10;
            plus = sum / 10;
            current.next = new ListNode(nodeVal);
            current = current.next;
            a = a!=null? a.next:null;
            b = b!=null? b.next:null;
        }
        return result.next;

    }

    //链表正向存放，即个位排在链表尾部
    /*
    * 1、检查链表长度，在短链表的前面补上0节点。
    * 2、
    * */

    //在短的链表前面补0结点。
    public static void Add0(ListNode a,ListNode b){
        int i = 0;
        while(a!=null){
            i++;
            a = a.next;
        }

        int j = 0;
        while(b!=null){
            j++;
            b = b.next;
        }

        if (i>j){
            int diff = i-j;
            while(diff--!=0){
                ListNode Node0 = new ListNode(0);
                Node0.next = b;
                b = Node0;
            }
        }else{
            int diff = j-i;
            while(diff--!=0){
                ListNode Node0 = new ListNode(0);
                Node0.next = a;
                a = Node0;
            }
        }
    }






    public static void main(String[] args) {
        ListNode aHead = new ListNode(7);
        aHead.next = new ListNode(1);
        aHead.next.next = new ListNode(6);

        ListNode bHead = new ListNode(5);
        bHead.next = new ListNode(9);
        bHead.next.next = new ListNode(4);

        ListNode result = plusAB(aHead,bHead);

        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
