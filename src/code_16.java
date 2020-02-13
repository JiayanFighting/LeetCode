import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_16 {
    public static void main(String [] args){
        int[] nums = {0,1,2};
        int target = 1;
        int ret =  threeSumClosest(nums, target);
        System.out.println(ret);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if (nums == null || nums.length < 3){
            return sum;
        }
        Arrays.sort(nums);
        int ret = Integer.MAX_VALUE;
        for (int i = 0;i<nums.length-2;i++){
            int left = i+1,right = nums.length-1;
            while (left < right){
                int cret = nums[i] + nums[left] +nums[right] - target;
                if ( cret == 0){
                    return target;
                }else if (cret < 0){
                    left++ ;
                }else {
                    right --;
                }
                if (Math.abs(cret) < ret){
                    ret = Math.abs(cret);
                    sum = cret + target;
                }
            }
        }
        return sum;

    }
}
