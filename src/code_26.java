public class code_26 {
    public static void main(String [] args){
        int[] nums = {1,1,1,2,2,3,4,5,6,6};
        int ret = removeDuplicates(nums);
        System.out.println(ret);
        for (int i = 0; i < ret; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length <=1){
            return nums.length;
        }
        int len = nums.length;
        for (int i =1;i<len;i++){
            if (nums[i] == nums[i-1]){
                change(nums,i);
                i--;
                len --;
            }else if (nums[i] < nums[i-1]){
                break;
            }
        }
        return len;
    }

    public static void change(int[] nums,int k){
        int tag = nums[k];
        for (int i = k+1;i<nums.length;i++){
            nums[i-1] = nums[i];
        }
        nums[nums.length-1] = tag;
    }
}
