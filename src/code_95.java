import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_95 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(3);
        List<TreeNode> ret = generateTrees(2);
    }

    //栈
    public static List<TreeNode> generateTrees(int n) {
        
        List<TreeNode> inOrder = new ArrayList<>();
        return inOrder;
    }

    public static void helper(TreeNode root,List<Integer> inOrder){
        if (root == null){
            return;
        }
        helper(root.left,inOrder);
        inOrder.add(root.val);
        helper(root.right,inOrder);
    }
}
