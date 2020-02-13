public class code_75 {
    public static void main(String[] args){
        int[] nums = {1,2,0};
        sortColors(nums);
        for (int num:nums){
            System.out.print(num+" ");
        }
    }


    public static void sortColors(int[] nums) {
        if (nums.length <=1){
            return;
        }
        int redLast = 0;
        int blueBegin = nums.length-1;
        for (int i = 0;i<nums.length;i++){
            if (nums[i] == 0 && i > redLast){
                int x = nums[redLast];
                nums[redLast] = nums[i];
                nums[i] = x;
                redLast ++;
                i--;
            }else if (nums[i] == 2 && i < blueBegin){
                int x = nums[blueBegin];
                nums[blueBegin] = nums[i];
                nums[i] = x;
                blueBegin --;
                i--;
            }
        }
    }


}
