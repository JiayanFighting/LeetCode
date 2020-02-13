import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code_110 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root){
        if (root == null) return true;
        if (Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1){
            return isBalanced(root.left) && isBalanced(root.right) ;
        }else return false;
    }

    public static int treeDepth(TreeNode root){
        if (root == null) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left,right)+1;
    }

}
