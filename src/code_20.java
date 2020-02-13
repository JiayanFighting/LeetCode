import java.util.Stack;

public class code_20 {

    public static void main(String[] args){
        String s = "()[]{}";
        boolean ret = isValid(s);
        System.out.println(ret);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if (!stack.empty()){
                char peek = stack.peek();
                if ( (peek == '(' && c == ')')||(peek == '[' && c == ']')||(peek == '{' && c == '}') ){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
