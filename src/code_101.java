public class code_101 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        boolean ret= isSymmetric(root);
        System.out.println(ret);
    }

    public static boolean isSymmetric(TreeNode root){
        if (root == null){
            return true;
        }
        return helper(root.left,root.right);
    }

    public static boolean helper(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        return left.val == right.val && helper(left.left,right.right) && helper(left.right,right.left);
    }

}
