public class code_44 {
    public static void main(String[] args){
        String s = "adceb";
        String p = "*a*b";
        boolean ret = isMatch(s,p);
        System.out.println(ret);
    }

    public static boolean isMatch(String s, String p) {
        //dp[i][j]表示到第i个字符与第j个pattern是否匹配
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 1;j<=p.length();j++){
            if (p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }else { // ? or a-z
                dp[0][j] = false;
            }
        }
        for (int i = 1;i<=s.length();i++){
            for (int j = 1;j<=p.length();j++){
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j] ;
                }else {//都是字母但是不相等
                    dp[i][j] = false;
                }
            }
        }
        return  dp[s.length()][p.length()];
    }
}
