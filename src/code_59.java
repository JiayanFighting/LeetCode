import java.util.ArrayList;
import java.util.List;

public class code_59 {
    public static void main(String[] args){
        int[][] matrix = generateMatrix(5);

        assert matrix != null;
        for (int[] nums:matrix){
            for (int num:nums){
                System.out.print(num+" ");
            }
            System.out.println();
        }
        // 1 2 3 10
        // 4 5 6 11
        // 7 8 9 12
        // 14 15 16 17
        // 18 19 20 21
    }

    public static int[][] generateMatrix(int n){

        int[][] matrix = new int[n][n];
        if (n <= 0) return matrix;
        int num = 1;
        int rowBegin = 0 , rowEnd = n-1;//行 i
        int colBegin = 0, colEnd = n-1;//列 j
        while (rowBegin<=rowEnd && colBegin<=colEnd){
            //向左
            for (int j = colBegin;j<=colEnd;j++){
                matrix[rowBegin][j] = num;
                num++;
            }
            //向下
            for (int i = rowBegin+1;i<=rowEnd;i++){
                matrix[i][colEnd] = num;
                num++;
            }
            if (rowBegin < rowEnd) { // 多行
                //向右
                for (int j = colEnd-1;j>=colBegin;j--){
                    matrix[rowEnd][j] = num;
                    num++;
                }
            }
            if (colBegin < colEnd){
                //向上
                for (int i = rowEnd-1;i>=rowBegin+1;i--){
                    matrix[i][colBegin] = num;
                    num++;
                }
            }
            rowBegin++;
            rowEnd--;
            colBegin++;
            colEnd--;
        }
        return matrix;
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix.length == 0||matrix[0].length == 0) return ret;
        int rowBegin = 0 , rowEnd = matrix.length-1;//行 i
        int colBegin = 0, colEnd = matrix[0].length-1;//列 j
        while (rowBegin<=rowEnd && colBegin<=colEnd){
            //向左
            for (int j = colBegin;j<=colEnd;j++){
                ret.add(matrix[rowBegin][j]);
            }
            //向下
            for (int i = rowBegin+1;i<=rowEnd;i++){
                ret.add(matrix[i][colEnd]);
            }
            if (rowBegin < rowEnd) { // 多行
                //向右
                for (int j = colEnd-1;j>=colBegin;j--){
                    ret.add(matrix[rowEnd][j]);
                }
            }
            if (colBegin < colEnd){
                //向上
                for (int i = rowEnd-1;i>=rowBegin+1;i--){
                    ret.add(matrix[i][colBegin]);
                }
            }
            for (int num:ret){
                System.out.print(num+" ");
            }
            System.out.println();
            rowBegin++;
            rowEnd--;
            colBegin++;
            colEnd--;
        }
        return ret;
    }


}
