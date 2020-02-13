import java.util.ArrayList;
import java.util.List;

public class code_54 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,4,5},{7},{14},{18}};
        List<Integer> list = spiralOrder(matrix);

        for (int num:list){
            System.out.print(num+" ");
        }
        // 1 2 3 10
        // 4 5 6 11
        // 7 8 9 12
        // 14 15 16 17
        // 18 19 20 21
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
