import java.util.ArrayList;
import java.util.List;

public class code_78 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> list:res){
            for (int num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    //结果正确，但是顺序不对
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(new ArrayList<>(list));
        process(0,nums,list,res);
        return res;
    }

    public static void process(int start,int[] nums,List<Integer> list,List<List<Integer>> res){
        res.add(new ArrayList(list));
        for (int i = start;i<nums.length;i++){
            list.add(nums[i]);
            process(i+1,nums,list,res);
            list.remove(list.size()-1);
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
