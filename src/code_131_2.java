import java.util.ArrayList;
import java.util.List;

public class code_131_2 {
    public static void main(String[] args){
        String s = "aabaacaabba";
        System.out.println(minCut(s));
    }

    public static int minCut = -1;
    public static int minCut(String s) {
        if (s.length() == 0) return 0;
        if (isPalindrome(s)) return 0;
        helper(0,s,0);
        return minCut;
    }

    public static void helper(int start,String s,int cut){
        if (minCut >=0 && cut > minCut) return;
        if (start == s.length()){
            minCut = cut;
            return;
        }
        for (int i = start;i<s.length();i++){
            String s1 = s.substring(start,i+1);
            if (isPalindrome(s1)){
                helper(i+1,s,cut+1);
            }
        }

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
