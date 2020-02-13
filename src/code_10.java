public class code_10 {
    public static void main(String[] args){
        String s = "aaa";
        String p = ".*";
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
                if (j-2>=0){
                    dp[0][j] = dp[0][j] || dp[0][j-2];
                }
            }else { // . or a-z
                dp[0][j] = false;
            }
        }
        for (int i = 1;i<=s.length();i++){
            for (int j = 1;j<=p.length();j++){
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    if (j -2>= 0 && p.charAt(j - 2) != s.charAt(i-1) && p.charAt(j - 2) != '.'){//如果前一个元素不匹配 且不为任意元素
                        dp[i][j] = dp[i][j-2];
                    }else {
                        // dp[i][j-2] 没有匹配的情况
                        // dp[i][j-1] 单个字符匹配的情况
                        // dp[i-1][j] 多个字符匹配的情况
                        dp[i][j] = dp[i][j-2]  ||  dp[i][j-1]  ||  dp[i-1][j];
                    }
                }else {//都是字母但是不相等
                    dp[i][j] = false;
                }
            }
        }
        return  dp[s.length()][p.length()];
    }
}
