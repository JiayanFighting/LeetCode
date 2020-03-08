import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class code_31 {
    public static void main(String[] args){
        int[] nums = {3,5,4,2,1};// 2 1 3
        // 1 2 3 5 4 6
        nextPermutation(nums);
        for (int num:nums){
            System.out.print(num+" ");
        }
    }

    public static void nextPermutation(int[] nums) {
        // 下一个数比当前的大 且尽可能小的增大当前的数
        // 从后往前
        for (int i = nums.length-2;i>=0;i--){
            if (nums[i] < nums[i+1]){
                // i 后半段一定是降序排列的
                for (int j = nums.length-1;j>i;j--){
                    if (nums[j] > nums[i]){
                        // > i 最接近 i
                        swap(i,j,nums);
                        // 然后后半段从小到大排序
                        reversal(i+1,nums.length-1,nums);
                        return;
                    }
                }
            }
        }
        // 一直没找到 反转nums
        reversal(0,nums.length-1,nums);
    }

    public static void swap(int i , int j, int[] nums){
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }

    public static void reversal(int left,int right, int[] nums){
        while (left < right){
            swap(left,right,nums);
            left++;
            right--;
        }
    }
}
