import java.util.*;

public class code_15 {
    public static void main(String [] args){
        int[] nums = {-1, 0, 1, 2, -1, -4};//-2,0,0,2,2
        List<List<Integer>> ret = threeSum(nums);
        for (int i = 0;i<ret.size();i++){
            for (int j = 0;j<ret.get(i).size();j++){
                System.out.print(ret.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    // 双指针+排序
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length <= 3){
            return ret;
        }
        Arrays.sort(nums);
        for (int i = 0;i<nums.length;i++){
            if (nums[i] > 0) return ret;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1,right = nums.length-1;
            while (left < right){
                if (nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ret.add(new ArrayList<>(list));
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right --;
                    }
                    left++;
                    right--;
                }else if (nums[i] + nums[left] + nums[right] < 0){
                    left ++;
                }else {
                    right --;
                }
            }
        }
        return ret;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return ret;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] record = new boolean[nums.length];
        process(0,0,0,nums,record,list,ret);
        return ret;
    }

    public static void process(int dept ,int target, int start, int[] nums, boolean[] record,List<Integer> list, List<List<Integer>> ret){

        if (dept == 3 && target == 0){
            ret.add(new ArrayList<>(list));
            return;
        }
        if (dept >= 3){
            return;
        }
        for (int i = start;i<nums.length;i++){
            if (record[i] || (i>0 && nums[i-1] == nums[i] )){//|| (i>0 && nums[i-1] == nums[i])
                continue;
            }
            list.add(nums[i]);
            record[i] = true;
            process(dept+1,target-nums[i],i+1,nums,record,list,ret);
            list.remove(list.size()-1);
            record[i] = false;
        }

    }
}
