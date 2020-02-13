import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_46 {

    public static void main(String[] args){
        int[] nums = {1,2,3};
        List<List<Integer>> ret = permute(nums);
        for (List<Integer> integers : ret) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length == 0){
            return ret;
        }

        List<Integer> list = new ArrayList<>();
        process(nums.length, nums,list,ret);
        return ret;
    }

    public static void process(int size, int[] nums,List<Integer> list, List<List<Integer>> ret){
        if (size == 0){
            ret.add(new ArrayList<>(list));
            return;
        }else if(size<0){
            return;
        }
        for(int i = 0; i< nums.length;i++){
            if (!list.contains(nums[i])){
                list.add(nums[i]);
                process(size-1, nums,list,ret);
                list.remove(list.size()-1);
            }

        }
    }
}
