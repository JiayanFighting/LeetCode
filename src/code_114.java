import java.util.ArrayList;
import java.util.List;

public class code_114 {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
//        right.left = new TreeNode(6);
        right.right = new TreeNode(6);
        flatten(root);
        while (root!=null){
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void flatten(TreeNode root){
        // 把左子树展开为链表
        // 把右子树展开为链表
        // 根节点 左子树链表 右子树链表 连接在一起
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode node = root;
        while (node.right!=null){
            node = node.right;
        }
        node.right = right;
    }

}
