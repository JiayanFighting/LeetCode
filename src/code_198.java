import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class code_198 {
    public static void main(String[] args){
        int[] nums = {2,7,9,3,1,1,1,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2;i<nums.length;i++){
            // 当晚不打劫
            // 当晚打劫
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }
        return dp[len-1];
    }


}
