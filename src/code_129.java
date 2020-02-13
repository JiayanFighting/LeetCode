import org.omg.CORBA.TRANSACTION_MODE;

public class code_129 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
//        right.left = new TreeNode(6);
//        right.right = new TreeNode(20);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root){
        return helper(root,0);
    }

    public static int helper(TreeNode root,int sum){
        if (root == null){
            return 0;
        }
        sum += root.val;
        if (root.right == null && root.left == null){
            return sum;
        }
        return helper(root.left,sum*10) + helper(root.right,sum *10);
    }
}
