import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class code_30 {
    public static void main(String[] args){
        String s = "wordgoodbestwordgoodbestword";
        String[] words = {"word","good","best","word"};
        List<Integer> res = findSubstring(s,words);
        for (Integer ss:res){
            System.out.println(ss);
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return list;
        int len = words[0].length();//每个单词的长度
        int tlen = len * words.length;// 总的长度
        if (s.length() < tlen) return list;
        HashMap<String,Integer> wordsMap = new HashMap<>();
        for (int i = 0;i<words.length;i++){
            int num = wordsMap.getOrDefault(words[i],0);
            wordsMap.put(words[i],++num);
        }
        for (int i = 0;i<s.length()-tlen+1;i++){//滑动窗口的开始下标
            // i ~ i+len-1
            if (helper(s.substring(i,i+tlen),len,wordsMap)){
                list.add(i);
            }
        }

        return list;
    }


    public static boolean helper(String s,int len, HashMap<String,Integer> wordsMap){
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0;i<=s.length()-len;i=i+len){
            String ss = s.substring(i,i+len);
            if (!wordsMap.containsKey(ss)){
                return false;
            }else {
                int num = map.getOrDefault(ss,0); // 现在已有的个数
                num++;//加上现在这个
                if (num > wordsMap.get(ss)){
                    return false;
                }else {
                    map.put(ss,num);
                }
            }
        }
        return true;
    }
}
