public class code_74 {
    public static void main(String[] args){
        int[][] matrix = {{1,1}};//{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }

    //二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0 ||  matrix[0].length == 0){
            return false;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = m * n-1;
        int mid,midValue;
        while (left <= right){
            mid = (left+right)/2;
            midValue = matrix[ mid/n ][mid % n];
            if (midValue == target){
                return true;
            }else if(midValue < target){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }
        return false;
    }


    //从右上角开始
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 ||  matrix[0].length == 0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length-1;
        while (i < matrix.length && j>=0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }


}
