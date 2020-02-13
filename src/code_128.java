import java.util.HashMap;
import java.util.HashSet;

public class code_128 {

    public static void main(String[] args){
        int[] nums = {100,1,200,4,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums){

        if (nums.length <= 1){
            return nums.length;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int len  = 0;
        for (int num:set){
            if (!set.contains(num-1)){
                int  curlen = 1;
                int index = num +1;
                while (set.contains(index)){
                    curlen ++;
                    index ++;
                }
                len = Math.max(len,curlen);
            }
        }
        return len;
    }
}
