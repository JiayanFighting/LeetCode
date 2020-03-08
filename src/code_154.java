import java.util.PrimitiveIterator;

public class code_154 {
    public static void main(String[] args){
        int[] nums = {2,2,0,0,1};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;//最小值一定在mid右边
            else if (nums[mid] < nums[right]) right = mid; // 可能当前mid值就是最小值
            else right = right - 1;//一定在中间 一步一步一定 不用轻举妄动
        }
        return nums[left];
    }

    //二分查找  有重复元素
    //找拐点的位置   left  mid  right
    public static int findMin2(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length-1;
        int mid;
        int flag = 0;
        while (left <= right){
            mid = (left+right)/2;
            if (mid > 0 && nums[mid-1] > nums[mid]){ // 前一个元素大于当前元素
                return nums[mid];
            }else if (nums[left] > nums[mid] ){ // 拐点一定在左边
                right = mid - 1;
            }else if (nums[mid] > nums[right]){ // 拐点一定在右边
                left = mid + 1;
            }else if ((nums[left] < nums[mid] && nums[mid] <= nums[right]) || (nums[left] <= nums[mid] && nums[mid] < nums[right])){
                right = mid - 1;
            }else {
                left++;
                right--;
            }
            flag = mid;
        }
        return nums[flag];
    }
}
