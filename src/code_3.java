import java.util.HashMap;
import java.util.Set;

public class code_3 {
    public static void main(String[] args){
        String s = "pwwkew";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0,end = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (end < s.length()){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                start = Math.max(start,map.get(c)+1);
                map.put(c,end);
            }else {
                map.put(s.charAt(end),end);
            }
            max = Math.max(max,end-start+1);
            end ++ ;
        }
        return max;
    }
}
