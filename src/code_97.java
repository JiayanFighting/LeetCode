public class code_97 {
    public static void main(String[] args){
        String s1 = "a",s2 = "", s3="c";
        System.out.println(isInterleave(s1,s2,s3));

    }

    // 动态规划
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }



    // 回溯
    public static boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return helper(s1,s2,s3,0,0,0);
    }

    public static boolean helper(String s1, String s2, String s3,int index1,int index2,int index3){
        if (index1 >= s1.length() && index2 >= s2.length() && index3 >= s3.length()) return true;
        if (index1 >= s1.length()){
            return s2.charAt(index2) == s3.charAt(index3)?helper(s1,s2,s3,index1,index2+1,index3+1):false;
        }
        if (index2 >= s2.length()){
            return s1.charAt(index1) == s3.charAt(index3)?helper(s1,s2,s3,index1+1,index2,index3+1):false;
        }
        if (s1.charAt(index1) != s3.charAt(index3) && s2.charAt(index2) != s3.charAt(index3)) return false;
        if (s1.charAt(index1) == s3.charAt(index3) && s2.charAt(index2) == s3.charAt(index3)){
            return helper(s1,s2,s3,index1+1,index2,index3+1) || helper(s1,s2,s3,index1,index2+1,index3+1);
        }else if (s1.charAt(index1) == s3.charAt(index3) ){
            return helper(s1,s2,s3,index1+1,index2,index3+1);
        }else {
            return helper(s1,s2,s3,index1,index2+1,index3+1);
        }

    }
}
