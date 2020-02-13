import java.util.ArrayList;
import java.util.List;

public class code_113 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        root.left = left;
        root.right = right;
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);

    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        helper(root,sum,list,res);
        return res;
    }

    public static void helper(TreeNode root, int sum,List<Integer> list,List<List<Integer>> res){
        if (root == null){
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null){
            if (sum == 0){
                res.add(new ArrayList<>(list));
            }
        }
        helper(root.left,sum,list,res);
        helper(root.right,sum,list,res);
        list.remove(list.size()-1);
    }
}
