import java.util.ArrayList;
import java.util.List;

public class code_140 {
    public static void main(String[] args) {
        String s ="catsanddog";
        List<String> list = new ArrayList<>();//"cat", "cats", "and", "sand", "dog"
        list.add("cat");
        list.add("cats");
        list.add("dog");
        list.add("and");
        list.add("sand");
//        String s = "leetcode";
//        List<String> list = new ArrayList<>();
//        list.add("leet");
//        list.add("code");
//        list.add("sand");
        List<String> res = wordBreak(s,list) ;
        for (String ss:res)
        {
            System.out.println(s);
        }

    }

    // 动态规划
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if (len == 0) return res;
        boolean[] dp = new boolean[len+1];
        List<String>[] record = new ArrayList[len+1];
        dp[0] = true;
        List<String> list1 = new ArrayList<>();
        list1.add(" ");
        record[0] = list1;
        for (int i = 1;i<=len ;i++){
            for (int j = 0;j<i;j++){
                if (dp[j] &&  wordDict.contains(s.substring(j,i))){
                    List<String> list = new ArrayList<>();
                    for (int k = 0;k<record[j].size();k++){
                        list.add(record[j].get(k)+" "+s.substring(j,i));
                    }
                    dp[i] = true;
                    record[i] = list;
                    break;
                }
            }
        }
        return record[len];

    }

    //回溯 超时
    public static List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(0,"",s,wordDict,res);
        return res;

    }

    public static void helper(int start,String ans,String s, List<String> wordDict,List<String> res){
        if (start == s.length()){
            res.add(ans.substring(1));
            return;
        }

        for (int i= start+1;i<=s.length();i++ ){
            String ss = s.substring(start,i);
            if (wordDict.contains(ss)){
                helper(i,ans+" "+ss,s,wordDict,res);
            }
        }
    }
}
