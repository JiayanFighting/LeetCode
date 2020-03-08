import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class code_76 {
    public static void main(String[] args){
        String s = "";
        String t = "";
        System.out.println(minWindow(s,t));
    }

    // 滑动窗口
    public static String minWindow(String s, String t) {
        if (s.length() < t.length() || t.length() == 0) return "";
        int left = 0, right = 0;
        HashMap<Character,Integer> need = new HashMap<>();
        for (int i = 0;i<t.length();i++){
            int num = need.getOrDefault(t.charAt(i),0);
            need.put(t.charAt(i),++num);
        }
        Queue<Character> queue = new LinkedList<>();
        boolean leftFlag = false,rightFlag = false;
        HashMap<Character,Integer> need2 = new HashMap<>(need);
        for (int i = 0;i<s.length();i++){
            if (need.containsKey(s.charAt(i))){
                int num = need2.get(s.charAt(i));

                if (!leftFlag){
                    left = i;
                    leftFlag = true;
                }
            }
            if (leftFlag){
                queue.add(s.charAt(i));
            }
        }

        return "";
    }


}
