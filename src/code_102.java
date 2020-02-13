import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class code_102 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> list : res){
            for (int num : list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static  List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0;i<len;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            ret.add(new ArrayList<>(list));
        }
        return ret;
    }


    public static  List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num1=1;
        int num2=0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            num1--;
            if (node.left != null){
                queue.add(node.left);
                num2++;
            }
            if (node.right != null){
                queue.add(node.right);
                num2++;
            }
            if (num1 <= 0){
                ret.add(new ArrayList<>(list));
                list = new ArrayList<>();
                num1 = num2;
                num2 = 0;
            }
        }
        return ret;
    }

}
