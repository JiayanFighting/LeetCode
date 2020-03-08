import java.util.Stack;

public class code_85 {
    public static void main(String[] args) {
        char[][] matrix = {{'1'}};
        int ret = maximalRectangle(matrix);
        System.out.println(ret);

    }
    public static int maximalRectangle(char[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int ans = 0;
        int[][] height = new int[matrix.length+1][matrix[0].length];
        for (int row = 0;row<matrix.length;row++){
            // 计算height
           for (int col = 0; col < matrix[row].length;col++){
               if (matrix[row][col] == '1'){
                   height[row+1][col] = height[row][col]+1;
               }else {
                   height[row+1][col] = 0;
               }
           }
           int max = largestRectangleArea(height[row+1]);
           ans = Math.max(max,ans);
        }

        return ans;
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
