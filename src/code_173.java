import java.util.ArrayList;
import java.util.List;

public class code_173 {
    public static void main(String[] args){

    }

}

class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int index = -1;
    // 中序遍历二叉搜索树得到一个数组
    public BSTIterator(TreeNode root) {
        inOrder(root);
    }

    /** @return the next smallest number */
    public int next() {
        index ++;
        return list.get(index);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size()-1;
    }

    public void inOrder(TreeNode root){
        if (root == null) return ;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);

    }
}
