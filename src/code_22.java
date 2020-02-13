import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code_22 {
    public static void main(String[] args){
        int n =3;
        List<String> ret = generateParenthesis(n);
        for (int i= 0; i<ret.size();i++){
            System.out.println(ret.get(i));
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        getParenthesis("",n,n,list);
        return  list;
    }

    public static void getParenthesis(String s , int left,int right,List<String> list){
        if (left == 0 && right == 0){
            list.add(s);
            return;
        }
        if (left > 0){
            getParenthesis(s+"(",left-1,right,list);
        }
        if (right > 0 && left < right){
            getParenthesis(s+")",left,right-1,list);
        }
    }
}
