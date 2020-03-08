public class code_42 {
    public static void main(String[] args){
        int[] height = {1,2,3,2,1,4};
        System.out.println(trap(height));
    }

    public static int trap(int[] height)  {
        if (height.length<=2) return 0;
        int leftmax = 0,rightmax=0;
        int left = 0 ,right = height.length-1;
        int ans = 0;
        while (left<right){
            if (height[left] < height[right]){//移动左指针
                if (height[left] > leftmax){// 爬上坡 记录左边最高的
                    leftmax = height[left];
                }else {// 走下坡 可积水
                    ans += leftmax-height[left];
                }
                left ++;
            }else {//移动右指针
                if (height[right] > rightmax){// 爬上坡 记录右边最高的
                    rightmax = height[right];
                }else {// 走下坡 可积水
                    ans += rightmax-height[right];
                }
                right --;
            }
        }
        return ans;
    }

}
