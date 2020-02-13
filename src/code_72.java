public class code_72 {
    public static void main(String[] args){
        String word1="1111";
        String word2 = "111111";
        int ret = minDistance(word1,word2);
        System.out.println(ret);
    }

    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0 ){
            return word2.length();
        }else if (word2.length() == 0){
            return word1.length();
        }
        int[][] dp =new int[word1.length()][word2.length()];
        dp[0][0] = word1.charAt(0) == word2.charAt(0)?0:1;
        for (int i = 1;i<word1.length();i++){
                dp[i][0] = dp[i-1][0]+1;
        }
        for (int i = 1;i<word2.length();i++){
                dp[0][i] = dp[0][i-1]+1;
        }
        for (int i = 1;i<word1.length();i++){
            for (int j = 1;j<word2.length();j++){
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }

            }
        }
        return dp[word1.length()-1][word2.length()-1];
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m <= 0){
            return 0;
        }
        int n = grid[0].length;
        if (n <= 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];

            }
        }
        return dp[m-1][n-1];

    }

}
