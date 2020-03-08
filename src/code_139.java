import java.util.ArrayList;
import java.util.List;

public class code_139 {
    public static void main(String[] args){
//        String s ="catsandog";
//        List<String> list = new ArrayList<>();
//        list.add("cats");
//        list.add("dog");
//        list.add("san");
        String s ="leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        list.add("sand");
        System.out.println(wordBreak(s,list));
    }

    // 动态规划
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        if (len == 0) return true;
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 1;i<=len ;i++){
            for (int j = 0;j<i;j++){
                if (dp[j] &&  wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    // 递归 二分 超时
    public static boolean wordBreak2(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        boolean[][] record = new boolean[s.length()][s.length()];
        return helper(0,s.length()-1,s,wordDict,record);
    }

    public static boolean helper(int begin,int end,String s,List<String> wordDict,boolean[][] record){
        if (begin >= s.length() || end >= s.length()|| end <0|| begin < 0)
            return false;
        if (begin > end)
            return true;
        String ss = s.substring(begin,end+1);
        if (wordDict.contains(ss)){
            record[begin][end] = true;
            return true;
        }
        for (int i = begin+1;i<=end;i++){
            //从i处分割
            boolean left = record[begin][i-1];
            if (!left){
                left = helper(begin,i-1,s,wordDict,record);
            }
            boolean right = record[i][end];
            if (!right){
                right = helper(i,end,s,wordDict,record);
            }
            if (left && right){
                record[begin][end] = true;
                return true;
            }
        }
        return false;
    }
}
