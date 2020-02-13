public class code_130 {
    public static void main(String[] args){
        char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};//{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //[["X","O","X","O","X","O"],["O","X","O","X","O","X"],["X","O","X","O","X","O"],["O","X","O","X","O","X"]]
        for (char[] cc :board){
            for (char c:cc){
                System.out.print(c+" ");
            }
            System.out.println();
        }
        System.out.println();
        solve(board);
        for (char[] cc :board){
            for (char c:cc){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        if (board.length == 0 || board[0].length ==0){
            return;
        }
        boolean[][] check = new boolean[board.length][board[0].length];
        for (int i = 0;i<board.length;i++){
            helper(board,i,0,check);
            helper(board,i,board[i].length-1,check);
        }
        for (int i = 0;i<board[0].length;i++){
            helper(board,0,i,check);
            helper(board,board.length-1,i,check);
        }
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[i].length;j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[i].length;j++){
                if (board[i][j] == 'P'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void helper(char[][] board,int x,int y,boolean[][] check){
        if (x < 0 || y < 0 || x>= board.length || y>= board[0].length || check[x][y] ||board[x][y] == 'X'){
            return;
        }
        check[x][y] = true;
        //上
        helper(board,x-1,y,check);
        //下
        helper(board,x+1,y,check);
        //左
        helper(board,x,y-1,check);
        //右
        helper(board,x,y+1,check);
        board[x][y] = 'P';
    }


}
