import java.util.ArrayList;
import java.util.List;

public class code_132 {
    public static void main(String[] args){
        String s = "aab";
        System.out.println(minCut(s));

    }

    public static int minCut(String s){
        if (s.length() == 0) return 0;
        if (isPalindrome(s)) return 0;
        int min = s.length()-1;
        for (int i = 1;i< s.length();i++){
            if (min<=1) return min;
            int left = helper(s,0,i);
            int right = helper(s,i,s.length());
            min = Math.min(left+right+1,min);
        }
        return min;
    }

    public static int helper(String ss,int begin,int end){
        if (ss.length() == 0) return 0;
        if (begin>=end) return 0;
        String s = ss.substring(begin,end);
        if (isPalindrome(s)) return 0;
        int min = s.length()-1;
        for (int i = begin+1;i< end;i++){
            int left = helper(ss,begin,i);
            int right = helper(ss,i,end);
            min = Math.min(left+right+1,min);
        }
        return min;
    }

    public static boolean isPalindrome(String s){
        if (s.length() == 0) return true;
        int left = 0,right=s.length()-1;
        while (left<right){
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }

}
