public class code_55 {
    public static void main(String[] args){
        int[] nums = {0,1,2,3,4};
        boolean ret = canJump(nums);
        System.out.println(ret);
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        if (nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        for (int i = 0; i<nums.length-1 ;i++){
            if (max < i){
                return false;
            }
            max = Math.max(nums[i] + i,max);
            if (nums[i] + i >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
