public class code_136 {
    public static void main(String[] args){
        int[] nums = {2,2,1};
        int ret = singleNumber(nums);
        System.out.println(ret);
    }

    public static int singleNumber(int[] nums){
        if (nums.length == 0) return 0;
        int ret = nums[0];
        for (int i =1;i<nums.length;i++){
            ret ^= nums[i];
        }
        return ret;
    }

}
