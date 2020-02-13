public class code_124 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(-2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
//        right.left = new TreeNode(6);
//        right.right = new TreeNode(20);
        System.out.println(maxPathSum(root));
    }

    // 左子树最大值+右子树最大值+val || 左子树为root的最大值 || 右子树为root的最大值 || root + 左子树 || root + 右子树 || root
    public static int maxPathSum(TreeNode root){
        if (root == null){
            return 0;
        }
        int val = Math.max(Math.max(pathSum(root.left),0)+Math.max(pathSum(root.right),0),0)+root.val;
        if (root.left!=null){
            int left = maxPathSum(root.left);
            val = Math.max(val,left);
        }
        if (root.right!=null){
            int right = maxPathSum(root.right);
            val = Math.max(val,right);
        }
        return val;
    }

    public static int pathSum(TreeNode root){
        if (root == null){
            return 0;
        }
        int max = 0;
        if (root.left != null){
            int left = pathSum(root.left);
            max = Math.max(max,left);
        }
        if (root.right != null){
            int right = pathSum(root.right);
            max = Math.max(max,right);
        }
        return max+root.val;
    }
}
