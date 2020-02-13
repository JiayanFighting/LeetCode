public class code_108 {

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        TreeNode ret= sortedArrayToBST(nums);
        System.out.println(ret);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public static TreeNode helper(int[] nums,int left,int right){
        if (left > right || left < 0 || left >= nums.length || right >= nums.length) return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }

}
