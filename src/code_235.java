public class code_235 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(6);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val == q.val) return p; // 同一节点
        if (p.val == root.val) return p; // p是q的祖先
        if (q.val == root.val) return q; // q是p的祖先
        if (p.val < root.val && q.val < root.val){ // 两个结点都在左边
            return lowestCommonAncestor(root.left,p,q);
        }else if (p.val > root.val && q.val > root.val){// 两个结点都在右边
            return lowestCommonAncestor(root.right ,p,q);
        }else{ // 一个在左边一个在右边
            return root;
        }
    }
}
