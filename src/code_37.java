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
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        // 初始化
        for (int i = 0;i<9;i++){
            for (int j = 0; j< 9;j++){
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9){
                    int blocknum = (i / 3 )*3+ j/3;// 0~8
                    row[i][num] = true;
                    col[j][num] = true;
                    block[blocknum][num] = true;
                }
            }
        }
        solve(0,0,board,row,col,block);
    }

    public static boolean solve(int x,int y,char[][] board,boolean[][] row,boolean[][] col,boolean[][] block){
        if (x>=9)
            return true;
        if (board[x][y] == '.'){ // 这个位置需要填
            for (int num = 1;num<=9;num++){
                int blocknum = (x / 3 )*3+ y/3;// 0~8
                boolean used = row[x][num] || col[y][num] || block[blocknum][num];
                if (!used){//这个数字目前可以填在这个位置
                    row[x][num] = true;
                    col[y][num] = true;
                    block[blocknum][num] = true;
                    board[x][y] = (char)(num+48);
                    boolean finish ;
                    if (y == 8){//最后一列 下一行
                        finish = solve(x+1,0,board,row,col,block);
                    }else {
                        finish = solve(x,y+1,board,row,col,block);
                    }
                    if (finish){
                        return true;
                    }else {
                        row[x][num] = false;
                        col[y][num] = false;
                        block[blocknum][num] = false;
                        board[x][y] = '.';
                    }
                }
            }
        }else {//下一个
            boolean finish ;
            if (y == 8){//最后一列 下一行
                finish = solve(x+1,0,board,row,col,block);
            }else {
                finish = solve(x,y+1,board,row,col,block);
            }
            return finish;
        }
        return false;
    }
}
