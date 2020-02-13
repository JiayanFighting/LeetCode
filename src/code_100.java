public class code_100 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        boolean ret= isSameTree(root,root);
        System.out.println(ret);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        if (p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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
