public class code_73 {
    public static void main(String[] args){
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for (int[] line:matrix){
            for (int num:line){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    //空间复杂度 m+n
    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        boolean[] line = new boolean[matrix.length];
        boolean[] row = new boolean[matrix[0].length];
        for (int i = 0; i< matrix.length;i++){
            for (int j = 0;j<matrix[i].length;j++){
                if (matrix[i][j] == 0){
                    line[i] = true;
                    row[j] = true;
                }
            }
        }
        for (int i = 0; i< matrix.length;i++){
            for (int j = 0;j<matrix[i].length;j++){
                if (line[i] || row[j]){
                    matrix[i][j] = 0;
                }
            }
        }

    }


}
