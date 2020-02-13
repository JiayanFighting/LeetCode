public class code_106 {

    public static void main(String[] args){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode ret= buildTree(inorder,postorder);
        System.out.println(ret);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    public static TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd,int postStart,int postEnd){
        if (inStart < 0 || postStart < 0 ||  inEnd>= inorder.length ||postEnd >= postorder.length ||  postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int k = inStart,num = 0;//k 为 inorder 中 的root
        for (;k<=inEnd;k++){
            if (inorder[k] == postorder[postEnd]) break;
            num ++;
        }
        root.left  = helper(inorder,postorder,inStart,k-1,postStart,postStart+num-1);
        root.right  = helper(inorder,postorder,k+1,inEnd,postStart+num,postEnd-1);
        return root;
    }

}
