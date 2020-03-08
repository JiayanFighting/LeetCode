import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code_199 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(5);
        root.left = left;

        TreeNode right = new TreeNode(7);
        root.right = right;
        left.right = new TreeNode(1);

        List<Integer> list = rightSideView(root);
        for (int num:list){
            System.out.print(num+" ");
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        // 按层遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if (i == size-1){
                    list.add(node.val);
                }
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }

        }
        return list;
    }
}
