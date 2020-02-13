import java.util.HashMap;

public class code_91 {
    public static int num = 0;
    public static void main(String[] args){
        String s = "226";
        int ret = numDecodings(s);
        System.out.println(ret);
    }

    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i<=s.length();i++){
            if (s.charAt(i-1) == '0'){ // .0
                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2'){ // 10 20
                    dp[i] = dp[i-2];
                }else {
                    dp[i] = 0;
                }
            }else{// 1 2 3 4 5 6 7 8 9
                if (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) >= '1' && s.charAt(i-1) <= '6')){
                    dp[i] = dp[i-1] + dp[i-2];
                }else{
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[s.length()];

    }


}
