import java.lang.reflect.Array;

public class code_4 {
    public static void main(String[] args){
        int[] nums1 = {1,3,4};
        int[] nums2 = {7,8,9};
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
