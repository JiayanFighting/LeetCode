import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_41 {

    public static void main(String[] args){
        int[] nums = {1,2,0};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        int res = 1;
        int left = 1, right = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= 0){
                continue;
            }
            left = nums[i] -1;
        }
        return res;
    }
}
