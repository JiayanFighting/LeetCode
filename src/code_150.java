import java.util.Stack;

public class code_150 {
    public static void main(String[] args){
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<String> stack = new Stack<>();
        stack.push(tokens[0]);
        int sum = Integer.parseInt(tokens[0]);
        for (int i = 0;i<tokens.length;i++){
            if (tokens[i].equals("+") || tokens[i].equals("-")|| tokens[i].equals("*")|| tokens[i].equals("/")){
                int one = Integer.parseInt(stack.pop());
                int two = Integer.parseInt(stack.pop());
                switch (tokens[i]) {
                    case "+":
                        sum = one + two;
                        break;
                    case "-":
                        sum = two - one;
                        break;
                    case "*":
                        sum = one * two;
                        break;
                    default:
                        sum = two / one;
                        break;
                }
                stack.push(String.valueOf(sum));
            }else {
                stack.push(tokens[i]);
            }
        }
        return sum;
    }
}
