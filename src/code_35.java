public class code_35 {
    public static void main(String[] args){
        int[] nums = {1,3,5,7};
        int target = 9;
        int ret = searchInsert(nums,target);
        System.out.println(ret);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        if (nums[0] > target){
            return 0;
        }
        int left = 0, right = nums.length -1,last = 0;
        int mid;
        while (left <= right ){
            mid = (left + right) / 2 ;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
                last = mid;
            }else{
                right = mid - 1;
                if (nums[left] < target){
                    last = left;
                }
            }
        }
        return last+1;
    }
}
