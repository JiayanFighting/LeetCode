public class code_152 {
    public static void main(String[] args){
        int[] nums = {-2,0,-1,1,4,6,-2,4,-1,0,4,2,6,-1,-4};
        int ret = maxProduct(nums);
        System.out.println(ret);
    }

    // 优化 动态规划
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for (int i=1;i<nums.length;i++){
            // 负数 可能会把最小的数变最大或者把最大的数变最小
            int tmpimax = Math.max(nums[i],Math.max(imax * nums[i],imin * nums[i]));
            imin = Math.min(nums[i],Math.min(imin * nums[i],imax*nums[i]));
            imax = tmpimax;
            max = Math.max(max,imax);
        }
        return max;
    }


    public static int maxProduct2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int[] dpmax = new int[nums.length]; // 以第i个结尾的最大值
        int[] dpmin = new int[nums.length]; // 以第i个结尾的最小值
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        for (int i=1;i<nums.length;i++){
            // 负数 可能会把最小的数变最大或者把最大的数变最小
            dpmax[i] = Math.max(nums[i],Math.max(dpmax[i-1]*nums[i],dpmin[i-1]*nums[i]));
            dpmin[i] = Math.min(nums[i],Math.min(dpmin[i-1]*nums[i],dpmax[i-1]*nums[i]));
            max = Math.max(max,dpmax[i]);
        }
        return max;
    }


}
