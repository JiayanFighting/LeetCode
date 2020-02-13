import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_94 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = new TreeNode(3);
        List<Integer> ret = inorderTraversal(root);
        for (int num :ret){
            System.out.print(num+" ");
        }
    }

    //栈
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if(root == null){
            return inOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            inOrder.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }

        }
        return inOrder;
    }

    //递归遍历
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        helper( root, inOrder);
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
