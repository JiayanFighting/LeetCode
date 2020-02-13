import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_39 {

    public static void main(String[] args){
        int[] candidates = {2,3,5};
        int target = 7;
        List<List<Integer>> ret = combinationSum(candidates,target);
        for (List<Integer> integers : ret) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 ){
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        process(0,target,candidates, list, res);
        return res;
    }

    public static void process(int start , int target,int[] candidates, List<Integer> list, List<List<Integer>> res){
        if (target < 0){
            return ;
        }else if (target == 0){
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i = start; i<candidates.length;i++){
            list.add(candidates[i]);
            process(i,target-candidates[i],candidates,list,res);
            list.remove(list.size()-1);
        }
    }
}
