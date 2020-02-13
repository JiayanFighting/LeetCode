import java.util.Stack;

public class code_84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int ret = largestRectangleArea(heights);
        System.out.println(ret);

    }

    // 栈
    public static int largestRectangleArea(int[] heights){
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0;i<heights.length;i++){
            while (stack.peek() != -1  && heights[i] < heights[stack.peek()]){
                max = Math.max(max, heights[stack.pop()] * (i-stack.peek()-1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1){
            max = Math.max(max, heights[stack.pop()] * (heights.length-stack.peek()-1));
        }

        return max;
    }

    //暴力法 o(n^2)
    public static int largestRectangleArea2(int[] heights) {
        int max = 0;
        for (int i = 0;i<heights.length;i++){
            int area =  heights[i];
            if (area * heights.length < max){
                max = Math.max(area,max);
                continue;
            }
            for (int left = i-1;left >= 0 ;left--){
                if (heights[left] < heights[i]){
                    break;
                }
                area += heights[i];
            }
            for (int right = i+1;right < heights.length;right++){
                if (heights[right] < heights[i]){
                    break;
                }
                area += heights[i];
            }
            max = Math.max(area,max);
        }


        return max;
    }


}
