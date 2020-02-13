public class code_164 {
    public static void main(String[] args){
        int[] nums = {3,6,9,1};
        int ret = maximumGap(nums);
        System.out.println(ret);
    }

    public static int maximumGap(int[] nums){
        if (nums.length <= 1) return 0;
        return -1;
    }
}
