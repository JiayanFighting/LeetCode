import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_90 {
    public static void main(String[] args){
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (List<Integer> list:res){
            for (int num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
//        res.add(new ArrayList<>(list));
        Arrays.sort(nums);
        boolean[] record = new boolean[nums.length];
        process(0,nums,list,res,record);
        return res;
    }

    public static void process(int start,int[] nums,List<Integer> list,List<List<Integer>> res,boolean[] record){

        res.add(new ArrayList(list));
        for (int i = start;i<nums.length;i++){
            // 剪枝
            if (i>=1 && nums[i-1] == nums[i] && !record[i-1]){
                continue;
            }
            list.add(nums[i]);
            record[i] = true;
            process(i+1,nums,list,res,record);
            list.remove(list.size()-1);
            record[i] = false;
        }
    }


    //List<List<Integer>> lists = new ArrayList<>();
    //    public List<List<Integer>> subsets(int[] nums) {
    //        if(nums == null || nums.length ==0){
    //            return lists;
    //        }
    //
    //        List<Integer> list = new ArrayList<>();
    //        process(list, nums, 0);
    //        return lists;
    //
    //    }
    //
    //    private void process(List<Integer>list, int[] nums, int start){
    //
    //        lists.add(new ArrayList(list));
    //        for(int i = start; i < nums.length; i++){
    //
    //            list.add(nums[i]);
    //            process(list, nums, i+1);
    //            list.remove(list.size()-1);
    //        }
    //    }


}
