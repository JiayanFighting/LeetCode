public class code_53 {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ret = maxSubArray(nums);
        System.out.println(ret);
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
            max = Math.max(max,nums[i]);
        }
        return max;
    }
}
