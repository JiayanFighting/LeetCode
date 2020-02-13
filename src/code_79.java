import com.sun.org.apache.regexp.internal.RE;

public class code_79 {
    private static boolean flag;

    public static void main(String[] args){
        String word="AAB";
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        boolean ret = exist(board,word);
        System.out.println(ret);
    }

    // dfs + 回溯 + 剪枝
    public static boolean exist(char[][] board, String word) {
        if (board.length ==0 || word.length() == 0){
            return false;
        }
        boolean[][] record = new boolean[board.length][board[0].length];
        for (int i =0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean ret = process(0, i, j, board, word,record);
                if (ret) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean process(int index,int x,int y,char[][] board, String word,boolean[][] record){
        if (x<0 || y<0 || x >= board.length|| y >= board[0].length || index <0 || index>= word.length()|| record[x][y]){
            return false;
        }
        if (board[x][y] != word.charAt(index) ){
            return false;
        }
        if (index == word.length()-1){
            flag = true;
            return true;
        }

        if (!flag){
            record[x][y] = true;
            boolean up = process(index+1,x-1,y,board,word,record);
            boolean down = process(index+1,x+1,y,board,word,record);
            boolean left = process(index+1,x,y-1,board,word,record);
            boolean right = process(index+1,x,y+1,board,word,record);
            record[x][y] = false;
            return up || down || left || right;
        }else {
            return true;
        }

    }
}
