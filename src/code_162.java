public class code_162 {
    public static void main(String[] args){
        int n = 1;
        int[] nums = {1};
        int ret = findPeakElement(nums);
        System.out.println(nums[ret]);
    }

    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int findPeakElement2(int[] nums) {
        int flag1 = -1;
        if (nums.length <= 1){
            return 0;
        }
        flag1 = helper(nums,0,nums.length-1);
        return flag1;
    }

    public static int helper(int[] nums,int left,int right){
        if (left > right) return -1;
        int mid = (left + right)/2;
        if (mid > 0 && mid < nums.length-1){
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }
        }else if (mid == 0){
            if (nums[mid] > nums[mid+1]){
                return mid;
            }
        }else {
            if (nums[mid] > nums[mid-1]){
                return mid;
            }
        }
        int flag1 = helper(nums,left,mid-1);
        int flag2 = helper(nums,mid+1,right);
        if (flag1 == -1 && flag2 == -1){
            return -1;
        }else {
            return flag1 == -1? flag2 :flag1;
        }
    }

}
