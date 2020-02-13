import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_144 {

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


    //栈
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if(root == null){
            return preOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            preOrder.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }

        }
        return preOrder;
    }

    //递归遍历
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        helper( root, inOrder);
        return inOrder;
    }

    public static void helper(TreeNode root,List<Integer> inOrder){
        if (root == null){
            return;
        }
        inOrder.add(root.val);
        helper(root.left,inOrder);
        helper(root.right,inOrder);
    }
}
