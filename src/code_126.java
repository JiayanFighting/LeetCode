import java.util.ArrayList;
import java.util.List;

public class code_126 {

    public static int maxDeep =  Integer.MAX_VALUE;
    public static void main(String[] args){
        List<String> wordList = new ArrayList<>();//"hot","dot","dog","lot","log","cog"

        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> res = findLadders(beginWord,endWord,wordList);
        for (List<String> list:res){
            for (String num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        }


    }

    public static  List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res= new ArrayList<>();
        if (beginWord.length() != endWord.length() || beginWord.length()==0||wordList.size()==0||beginWord.equals(endWord)) return res;
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        boolean[] record = new boolean[wordList.size()];
        helper(0,beginWord,endWord,wordList,record,list,res);
        return res;
    }

    public static void helper(int deep,String beginWord, String endWord, List<String> wordList,boolean[] record,List<String> list,List<List<String>> res){
        if (deep > maxDeep){
            return;
        }
        if (beginWord.equals(endWord)){
            res.add(new ArrayList<>(list));
            maxDeep = deep;
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
            list.add(wordList.get(i));
            helper(deep+1,wordList.get(i),endWord,wordList,record,list,res);
            record[i] = false;
            list.remove(list.size()-1);
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
