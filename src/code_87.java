public class code_87 {
    public static void main(String[] args){
        String s1 = "great";
        String s2 = "rgtae";
        boolean ret = isScramble(s1,s2);
        System.out.println(ret);
    }

    public static  boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        //dp[i][j]表示到第i个字符与第j个pattern是否匹配
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];

        return  dp[s1.length()][s2.length()];
    }
}
