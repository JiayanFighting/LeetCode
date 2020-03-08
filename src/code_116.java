import java.util.LinkedList;
import java.util.Queue;

public class code_116 {
    public static void main(String[] args){
        int n = 1;
        int[] nums = {1,2,3,4};
    }

    public static Node connect(Node root) {
        // 二叉树层次遍历
        // 同层的指向下一个，最后一个指向null
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0;i<size;i++){
                Node node = queue.poll();
                if (i == size-1){ // 最后一个节点
                    node.next = null;
                }else {
                    node.next = queue.peek();
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }

        return root;
    }


}
