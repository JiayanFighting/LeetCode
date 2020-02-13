public class code_112 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        System.out.println(hasPathSum(root,23));
    }

    public static boolean hasPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null){
            return sum ==0;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
