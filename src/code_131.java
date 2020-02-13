import java.util.ArrayList;
import java.util.List;

public class code_131 {
    public static void main(String[] args){
        String s = "aabaacaabba";
        List<List<String>> res = partition(s);
        for (List<String> list:res){
            for (String num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        if (s.length() == 0) return ret;
        List<String> list = new ArrayList<>();
        helper(0,s,list,ret);
        return ret;
    }

    public static void helper(int start,String s,List<String> list,List<List<String>> ret){
        if (start == s.length()){
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i<s.length();i++){
            String s1 = s.substring(start,i+1);
            if (isPalindrome(s1)){
                list.add(s1);
                helper(i+1,s,list,ret);
                list.remove(list.size()-1);
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
