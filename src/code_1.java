import java.util.HashMap;

public class code_1 {
    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = twoSum(nums, target);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }else {
                map.put(target-nums[i],i);
            }
        }
        return res;
    }
}
