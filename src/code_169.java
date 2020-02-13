import java.util.HashMap;

public class code_169 {
    public static void main(String[] args){
        int[] nums = {2,1,2,1,2};
        int ret = majorityElement(nums);
        System.out.println(ret);
    }

    public static int majorityElement(int[] nums){
        if (nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            int times = map.getOrDefault(num,0);
            if ((float)times+1 > (float)nums.length/2){
                return num;
            }
            map.put(num,times+1);
        }
        return nums[nums.length-1];
    }
}
