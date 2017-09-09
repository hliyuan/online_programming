package CrackCoding.package8_4;



/**
 * Created by liyuan on 2017/8/24.
 */
/*
实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个结点，
        其两棵子树的高度差不超过1。（第146页）
*/

public class Solution4_1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        Boolean result = isBalanced(root);
        System.out.println(result);
    }

    public static Boolean isBalanced(TreeNode root) {
        if (root==null) return true;

        int heghtDiff = getHeight(root.left) - getHeight(root.right);
        if (heghtDiff>1) return false;
        else
            return isBalanced(root.left)&&isBalanced(root.right);

    }

    public static int getHeight(TreeNode root){
        if (root ==null ) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;

    }
}
