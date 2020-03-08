import java.util.HashMap;

public class code_167 {
    public static void main(String[] args){

    }

    public static int[] twoSum(int[] numbers, int target){
        int[] ret = new int[2];
        if (numbers.length <= 1) return ret;
        int left = 0,right = numbers.length-1;
        while (left<right){
            if (numbers[left] + numbers[right] == target){
                ret[0] = left+1;
                ret[1] = right+1;
                return ret;
            }
            else if (numbers[left] + numbers[right] < target){
                left++;
            }else {
                right --;
            }
        }
        return ret;
    }
}
