import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class code_1 {
    public static void main(String[] args){
        System.out.println("hello");
        int[] nums = {4,3,3};
        int target = 6;
        int[] result = twoSum(nums, target);
        for (int i=0;i<2;i++){
            System.out.println(result[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i=0 ; i<nums.length;i++){
            int left = target - nums[i];
            if(map.get(left) != null){
                result[0] = map.get(left);
                result[1] = i;
                return result;
            }
            map.putIfAbsent(nums[i], i);
        }
        return result;
    }

    public static int[] twoSum_2(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i =0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int point_1 = 0;
        int point_2 = nums.length-1;
        while (point_1 != point_2){
            if (nums[point_1] + nums[point_2] == target){
                result[0] = map.get(nums[point_1]);
                result[1] = map.get(nums[point_2]);
                return  result;
            }else if (nums[point_1] + nums[point_2] < target){
                point_1 += 1;
            }else {
                point_2 -= 1;
            }
        }
        return result;
    }
}
