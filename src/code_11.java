import sun.nio.cs.ext.MacArabic;

import java.util.Map;

public class code_11 {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ret = maxArea(height);
        System.out.println(ret);
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right) {
            max = Math.max(max,(right-left)*Math.min(height[left],height[right]));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }



    public static int maxArea_1(int[] height) {
        int max = 0;
        int left = 0 , right = height.length-1;
        while (left <= right){
            int area = Math.min( height[left] , height[right]) * (right - left);
            max  = Math.max(max,area);
            if (height[left] < height[right]){
                left ++ ;
            }else {
                right --;
            }
        }
        return max;
    }
}
