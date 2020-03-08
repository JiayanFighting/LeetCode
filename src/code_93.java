import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code_93 {
    public static void main(String[] args){
        List<String> res = restoreIpAddresses("010010");
        for (String num:res){
            System.out.print(num+" ");
        }
    }

    // 递归
    public static List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        helper(0,4,"",s,list);
        return list;
    }
    // leftNum 剩余的数 总共为 4
    public static void helper(int start,int leftNum,String now,String s,List<String> list){
        if (leftNum == 0 && start == s.length()){
            list.add(now.substring(1));
            return;
        }
        if (leftNum < 0 || start >= s.length()){
            return;
        }

        for (int i = start;i<s.length();i++){
            String ss = s.substring(start,i+1);
            if (Integer.parseInt(ss) <0 || Integer.parseInt(ss) > 255 || (ss.charAt(0) == '0' && ss.length()>=2)){
                // 后面的不肯再满足条件
                return;
            }
            helper(i+1,leftNum-1,now+"."+ss,s,list);
        }

    }


}
