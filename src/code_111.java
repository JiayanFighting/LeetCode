import org.omg.PortableInterceptor.INACTIVE;

public class code_111 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
//        TreeNode right = new TreeNode(15);
        root.left = left;
//        root.right = right;
//        right.left = new TreeNode(6);
//        right.right = new TreeNode(20);
        System.out.println(minDepth(root));
    }

    public static int  minDepth2(TreeNode root){
        if (root == null) return 0;
        if (root.right == null ){
            return minDepth(root.left)+1;
        }else if (root.left == null){
            return minDepth(root.right)+1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left,right)+1;
    }

    public static int  minDepth(TreeNode root){
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 1;
        int min = Integer.MAX_VALUE;
        if (root.left!= null){
            min = Math.min(min,minDepth(root.left));
        }
        if (root.right != null){
            min = Math.min(min,minDepth(root.right));
        }
        return min+1;
    }

}
