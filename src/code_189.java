public class code_189 {
    public static void main(String[] args){
        int[] nums={0,1,2,3,4,5};
        int k=4;
        rotate(nums,k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k){
        if (nums.length <= 1 || k<= 0){
            return;
        }
        k = k % nums.length;
        if (k == 0){
            return;
        }
        reversal(0,nums.length-1,nums);
        reversal(0,k-1,nums);
        reversal(k,nums.length-1,nums);
    }

    public static void reversal(int begin, int end, int[] nums){
        for (int i = begin; i<(begin+end+1)/2;i++){
            int x = nums[i];
            nums[i] = nums[end-i+begin];
            nums[end-i+begin] = x;
        }
    }



    public static void rotate3(int[] nums, int k) {
        if (nums.length <= 1 || k<= 0){
            return;
        }
        k = k % nums.length;
        if (k == 0){
            return;
        }
        int index = nums.length-k;
        int nextIndex;
        int indexValue = nums[index];
        int times = 0;
        while (times <nums.length){
            nextIndex = (index + k) % nums.length;
            int nextIndexValue = nums[nextIndex];
            nums[nextIndex] = indexValue;
            index = nextIndex;
            indexValue = nextIndexValue;
            times ++;
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (nums.length ==0){
            return;
        }
        k = k % nums.length;
        if (k == 0){
            return;
        }
        int x ;
        int index;
        if (nums.length - k > k){
            for (int i = nums.length-k-1;i>=0;i--){
                index = i+k;
                x = nums[i];
                nums[i] = nums[index];
                nums[index] = x;
            }
        }else {
            for (int i = nums.length-k;i<nums.length;i++){
                index = i-(nums.length-k);
                x = nums[i];
                nums[i] = nums[index];
                nums[index] = x;
            }
        }

    }
}
