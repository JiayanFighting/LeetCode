import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class code_17 {

    public static void main(String[] args){
        String digits = "29";
        List<String> res = letterCombinations(digits);
        for (String re : res) {
            System.out.println(re);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        HashMap<Character,String > map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        process(0,digits,"",res,map);
        return res;
    }

    public static void process( int index,String digits,String str,List<String> res, HashMap<Character,String > map){
        //index 表示输入的字符串位置
        //start 表示键的位置
        if (index > digits.length()){
            return;
        }
        if (index == digits.length()){
            res.add(str);
            return;
        }
        char c = digits.charAt(index);
        String s = map.get(c);
        for (int i = 0;i<s.length();i++){
            process(index+1,digits,str + s.charAt(i),res,map);
        }
    }
}
