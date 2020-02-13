import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code_104 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        System.out.println(maxDepth(root));
    }

    public static  int maxDepth(TreeNode root){
        return helper(root,0);
    }

    public static int helper(TreeNode root,int depth){
        if (root == null){
            return depth;
        }
        return Math.max(helper(root.left,depth),helper(root.right,depth))+1;
    }
}
