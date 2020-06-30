
public class code_4 {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,7,8};
        int[] nums2 = {4,5,6};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int left1 = 0,right1= nums1.length-1;
        int left2 = 0,right2= nums2.length-1;

        while (left1 < right1) {
            int mid1 = (left1+right1)/2;
            int mid2 = (left2+right2)/2;
            if (nums1[mid1] < nums2[mid2]) {
                left1 = mid1+1;
                right2 = mid2-1;
            }else {
                left2 = mid2+1;
                right1 = mid1-1;
            }
        }

        return 0;
    }

    public static double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        double result = 0;
        int len = nums1.length + nums2.length;
        int left = -1,right = -1;
        int point_1 = 0 ,point_2 = 0 ;
        for (int i = 0;i<=len/2;i++){
            left = right;
            if(point_1 < nums1.length &&((point_2 >= nums2.length) || (nums1[point_1] < nums2[point_2] ) )){
                right = nums1[point_1];
                point_1++;
            }else{
                right = nums2[point_2];
                point_2 ++;
            }
        }
        if(len%2 == 1){
            result = right;
        }else{
            result = (left + right )/2.0;
        }
        return result;
    }
}
