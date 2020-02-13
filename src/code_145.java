import java.util.ArrayList;
import java.util.List;

public class code_145 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(3);
        List<Integer> ret = preorderTraversal(root);
        for (int num :ret){
            System.out.print(num+" ");
        }
    }

    //递归遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        helper( root, inOrder);
        return inOrder;
    }

    public static void helper(TreeNode root,List<Integer> inOrder){
        if (root == null){
            return;
        }
        helper(root.left,inOrder);
        helper(root.right,inOrder);
        inOrder.add(root.val);
    }
}
