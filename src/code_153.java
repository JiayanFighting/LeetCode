public class code_153 {
    public static void main(String[] args){
        int[] nums = {4,5,6,1,2,3};
        System.out.println(findMin(nums));
    }

    //二分查找
    public static int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int left = 0,right = nums.length-1;
        int mid;
        while (left <= right){
            mid = (left+right)/2;
            if (mid > 0 && nums[mid-1] > nums[mid]){ // 前一个元素大于当前元素
                return nums[mid];
            }else if (nums[mid] < nums[right]){ // 右边有序，拐点在左边
                right = mid - 1;
            }else { // 左边有序，拐点在右边
                left = mid + 1;
            }
        }
        return nums[0];
    }
}
