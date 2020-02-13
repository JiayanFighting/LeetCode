public class code_36 {
    public static void main(String[] args){
        char[][] board =  {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        boolean ret = isValidSudoku(board);
        System.out.println(ret);
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] line = new boolean[9][10];
        boolean[][] row = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        for (int i = 0;i<board.length;i++){
            for (int j = 0; j<board[i].length;j++){
                if (board[i][j] == '.'){
                    continue;
                }
                int num = board[i][j] - '0';
                int blocknum = (i / 3 )*3+ j/3;
                if (line[i][num] || row[j][num] || block[blocknum][num]){
                    return false;
                }
                line[i][num] = true;
                row[j][num] = true;
                block[blocknum][num] = true;
            }
        }

        return true;
    }
}
