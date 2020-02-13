import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_47 {

    public static void main(String[] args){
        int[] nums = {3,3,0,3};
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
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        boolean[] haveCheckList = new boolean[nums.length];
        process(0, nums,list,haveCheckList,ret);
        return ret;
    }

    public static void process(int dept, int[] nums,List<Integer> list, boolean[] haveCheckList,List<List<Integer>> ret){
        if (dept == nums.length){
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i< nums.length;i++){
            if (haveCheckList[i] || (i > 0 && nums[i] == nums[i-1] && haveCheckList[i-1] )){
                continue;
            }
            list.add(nums[i]);
            haveCheckList[i] = true;
            process(dept+1, nums,list,haveCheckList,ret);
            list.remove(list.size()-1);
            haveCheckList[i] = false;

        }
    }
}
