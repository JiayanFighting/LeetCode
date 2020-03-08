import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_41 {

    public static void main(String[] args){
        int[] nums = {1,5,4};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        // 缺失的正整数一定<= nums.length()+1
        // 将大于nums.length()+1和小于1的数全部替换成1
        // 然后用hashmap 存1-n每个数字是否出现过，没有出现的最小的数便是结果 但是空间复杂度不符合要求
        // 用数组本身作 哈希

        // 首先判断是否存在1
        boolean flag = false;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == 1){
                flag = true;
                break;
            }
        }
        if (!flag){
            return 1;
        }
        for (int i = 0;i<nums.length;i++){
            if (nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }

        // 数组下标表示这个数是否存在过，负数表示存在，正数表示不存在
        for (int i = 0;i<nums.length;i++){
            int a = Math.abs(nums[i]);
            // 更改下标为 a 的符号 为负
            if (a == nums.length){// 最后一个 放在第一位
                nums[0] = -Math.abs(nums[0]);
            }else {
                nums[a] =  - Math.abs(nums[a]);
            }
        }
        // 第一个为正数的就是缺失的那个数
        for (int i = 1;i<nums.length;i++){
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return nums.length;
        return nums.length+1;
    }
}
