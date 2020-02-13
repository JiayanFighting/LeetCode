public class code_48 {
    public static void main(String[] args){
        int[][] matrix = {{5, 1, 9,11} ,{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0 ; i< matrix.length;i++){
            for (int j = i ; j<matrix[i].length ; j++){
                int x = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = x;
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0 ; i< matrix.length;i++){
            for (int j = 0 ; j<=matrix[i].length /2-1 ; j++){
                int y2 = matrix[i].length - j-1;
                int x = matrix[i][j];
                matrix[i][j] = matrix[i][y2];
                matrix[i][y2] = x;
            }
        }
    }
}
