import sun.nio.cs.ext.MacArabic;

public class code_11 {
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ret = maxArea(height);
        System.out.println(ret);
    }

    public static int maxArea(int[] height) {
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
