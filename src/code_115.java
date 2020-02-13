public class code_115 {
    public static void main(String[] args){
        String s = "b",t = "a" ;
        System.out.println(numDistinct(s,t));

    }

    //动态规划
    public static int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];// dp[i][j] 代表 T 前 i 字符串可以由 S 前j字符串组成最多个数
        for (int i = 0;i<=s.length();i++){
            dp[0][i] = 1;
        }
        for (int i = 1;i<=t.length();i++){
            for (int j = i;j<=s.length();j++){
                dp[i][j] = t.charAt(i-1) == s.charAt(j-1)?dp[i][j-1]+dp[i-1][j-1]:dp[i][j-1];
            }
        }
        return dp[t.length()][s.length()];
    }

    // 回溯
    public static int numDistinct2(String s, String t) {
        if (s.length() < t.length()) return 0;
        if (s.length() == t.length()) return 1;

        return -1;
    }
}
