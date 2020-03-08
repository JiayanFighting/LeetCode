import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_95 {

    public static void main(String[] args){

        List<TreeNode> ret = generateTrees(3);
        for (TreeNode node:ret){
            System.out.println(node.val);
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n <= 0) return list;
        list = helper(1,n);
        return list;
    }
    public static List<TreeNode> helper(int begin,int end){
        List<TreeNode> list = new ArrayList<>();
        if (begin > end){
            list.add(null);
            return list;
        }
        for (int i = begin;i<=end;i++){
            List<TreeNode> left = helper(begin,i-1);
            List<TreeNode> right = helper(i+1,end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
