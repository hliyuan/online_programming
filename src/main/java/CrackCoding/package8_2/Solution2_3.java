package CrackCoding.package8_2;

/**
 * Created by liyuan on 2017/7/10.
 */

/**实现一个算法删除单项链表中间的某个结点，假设你只能访问该节点*/
public class Solution2_3 {

    public static boolean remove(LinkedListNode pNode){
        if (pNode.next==null)
            return false;
        else {
            pNode.data = pNode.next.data;
            pNode.next = pNode.next.next;
            return true;
        }
    }
}
