import java.util.ArrayList;
import java.util.List;

public class code_127 {

    public static int minDeep =  0;
    public static void main(String[] args){
        List<String> wordList = new ArrayList<>();//"hot","dot","dog","lot","log","cog"

        String beginWord = "hit";
        String endWord = "cog";
        int res = ladderLength(beginWord,endWord,wordList);
        System.out.print(res+" ");
    }

    public static  int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length() || beginWord.length()==0||wordList.size()==0||beginWord.equals(endWord)) return 0;
        boolean[] record = new boolean[wordList.size()];
        helper(0,beginWord,endWord,wordList,record);
        return minDeep;
    }

    public static void helper(int deep,String beginWord, String endWord, List<String> wordList,boolean[] record ){
        if (minDeep > 0 && deep > minDeep){
            return;
        }
        if (beginWord.equals(endWord)){
            minDeep = deep;
            return;
        }

        for (int i = 0;i<wordList.size();i++){
            // 剪枝
            // wordList的一个单词不能重复使用，会出现循环
            // beginword 是否可以变成 next ,即相差一个数
            // 最短的转换序列
            if (record[i] || !canChangeTo(beginWord,wordList.get(i))){
                continue;
            }
            record[i] = true;
            helper(deep+1,wordList.get(i),endWord,wordList,record);
            record[i] = false;
        }

    }

    public static boolean canChangeTo(String s1,String s2){
        if (s1.equals(s2) || s1.length() != s2.length()) return false;
        int num = 0;
        for (int i = 0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                num++;
                if (num > 1) return false;
            }
        }
        return true;
    }


}
