public class code_137 {
    public static void main(String[] args){
        int[] nums = {0,1,0,1,0,1,99};
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

    public static int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}
