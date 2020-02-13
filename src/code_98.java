import java.util.ArrayList;
import java.util.List;

public class code_98 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        boolean ret= isValidBST(root);
        System.out.println(ret);
    }

    public static boolean isValidBST(TreeNode root)  {
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, int lower,int upper){
        if (root == null){
            return true;
        }

        if (root.val+1 <= lower || root.val-1 >= upper ){
            return false;
        }
        return helper(root.left,lower,root.val-1) && helper(root.right,root.val+1,upper);
     }
}
