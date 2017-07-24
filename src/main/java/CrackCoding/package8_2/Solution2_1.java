package CrackCoding.package8_2;

/**
 * Created by liyuan on 2017/6/13.
 */



import java.util.HashMap;

/**
 * 编写代码，移除未排序链表的重复节点。
 * 进阶
 * 如果不能使用临时缓冲区，该怎么解决？
 * */
public class Solution2_1 {
    /*
    * 要想移除链表中重复的节点，我们需要设法记录有哪些是重复的。这里需要一个简单的散列表。
    * */
    public static void deleteDup1(LinkedListNode n ) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        LinkedListNode current = n;
        LinkedListNode previous = n;

        while(current!=null){
            if (map.containsKey(current.data)){
                previous.next = current.next;
            }else {
                map.put(current.data,1);
                previous = current;
            }
            current = current.next;
        }
        while(n!=null){
            System.out.print(n.data);
            n=n.next;
        }
    }

    //不使用临时缓冲区
    public static void deleteDups2(LinkedListNode n ) {
        if (n==null) return;
        LinkedListNode current = n;
        while(current!=null){
            LinkedListNode runner = current.next;

            while(runner!=null){
                if (current.data == runner.data)
                    current.next = runner.next;
                else {
                    runner = runner.next;
                }
            }
            current = current.next;

        }
        while(n!=null){
            System.out.print(n.data);
            n=n.next;
        }
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
        deleteDup1(head);
        System.out.println();
        deleteDups2(head);


    }
}
