import java.util.*;

public class code_103 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        List<List<Integer>> res = zigzagLevelOrder(root);
        for (List<Integer> list : res){
            for (int num : list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static  List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        boolean flag = true;
        while (!stack1.empty() || !stack2.empty()){
            List<Integer> list = new ArrayList<>();
            if (flag){ // stack1
                while (!stack1.empty()){
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left!=null) stack2.add(node.left);
                    if (node.right!=null) stack2.add(node.right);
                }
            }else {
                while (!stack2.empty()){
                    TreeNode node = stack2.pop();
                    list.add(node.val);
                    if (node.right!=null) stack1.add(node.right);
                    if (node.left!=null) stack1.add(node.left);
                }
            }
            ret.add(new ArrayList<>(list));
            flag = !flag;
        }
        return ret;
    }
}
