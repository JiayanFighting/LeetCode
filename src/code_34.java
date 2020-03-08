public class code_34 {
    public static void main(String[] args){
        int[] nums = {7,7,7,7,7,8};
        int target = 7;
        int[] ret = searchRange(nums,target);
        System.out.println(ret[0]+" " + ret[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = -1 , right = -1;
        int[] ret = {left,right};
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length-1] < target) {
            return ret;
        }
        left = 0;
        right = nums.length -1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                if (mid == 0 || nums[mid - 1] < target){
                    ret[0] = mid;
                    break;
                }else{ // nums[mid - 1] = target
                    right = mid-1;
                }
            }else if (nums[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        if (ret[0] == -1) return ret;
        left = ret[0];
        right = nums.length -1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                if (mid == nums.length-1 || nums[mid + 1] > target){
                    ret[1] = mid;
                    break;
                }else{ // nums[mid + 1] = target
                    left = mid + 1;
                }
            }else if (nums[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return ret;
    }


    public static int[] searchRange2(int[] nums, int target) {
        int end = -1 , start = -1;
        int[] ret = {start,end};
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length-1] < target) {
            return ret;
        }
        int left = 0, right = nums.length -1;
        int mid;
        while (left <= right){
            mid = (left + right) /2;
            if (nums[mid] == target){
                start = mid;
                end = start;
                for (int i = mid-1;i>=0;i--){
                    if (nums[i] == target){
                        start --;
                    }else {
                        break;
                    }
                }
                for (int j = mid+1;j<nums.length;j++){
                    if (nums[j] == target){
                        end ++;
                    }else {
                        break;
                    }
                }
                ret[0] = start;
                ret[1] = end;
                return ret;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return ret;
    }
}
