public class code_37 {
    public static void main(String[] args){
        char[][] board =  {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        for (char[] b :board){
            for (char num:b){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        helper(board,0,0);
    }

    public static void helper(char[][] board,int x,int y){
        if (x < 0 || y<0 || x>= board.length || y>=board[0].length) return;
        if (board[x][y] != '.') return;
        for (int num = 1;num<=9;num++){
            boolean flag = true;
            for (int i = 0;i<board.length;i++){
                if (board[i][y] == num){
                    flag = false;
                    break;
                }
            }
            for (int j = 0;j<board[x].length;j++){
                if (board[x][j] == num){
                    flag = false;
                    break;
                }
            }
            //方块
            if (flag){ // 当前 行 列 和 方块没有num这个数字
                board[x][y] = (char)(num+48);
                helper(board,x,y+1);
                helper(board,x+1,y);
                board[x][y] = '.';
            }
        }
    }
}
