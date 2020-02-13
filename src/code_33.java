public class code_33 {
    public static void main(String[] args){
        int[] nums = {4,2};
        int target = 4;
        int res = search(nums,target);
        System.out.println(res);
    }

    //划分升序的区域
    public static int search(int[] nums, int target) {
        int res = -1;
        int left = 0,right = nums.length-1;
        while (left <= right){
            int mid  = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[left] <= nums[mid]){ // 左边升序
                if (nums[left] <= target && nums[mid] > target){ // 在左边
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else{// 右边升序
                if (nums[mid] < target && nums[right] >= target){ // 在右边
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        return res;
    }
}
