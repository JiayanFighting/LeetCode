public class code_81 {
    public static void main(String[] args){
        int target = 3;
        int[] nums = {1,3,1,1,1};
        boolean ret = search(nums,target);
        System.out.println(ret);
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0){
            return false;
        }
        int left = 0, right = nums.length-1;
        int begin = nums[0] , end = nums[right];
        for (int i = 1;i<nums.length-1;i++){
            if (nums[i] != begin){
                break;
            }
            left ++;
        }
        for (int i = nums.length-2;i>=0;i--){
            if (nums[i] != end){
                break;
            }
            right --;
        }
        int mid;
        while (left <= right){
            mid = (left + right) /2;
            if (nums[mid] == target){
                return true;
            }else if ( nums[left] <= nums[mid]){  //左边有序
                if (nums[left] <= target && target <= nums[mid]){
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }else { // 右边有序
                if (nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid -1;
                }

            }
        }
        return false;
    }


}
