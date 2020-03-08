import java.util.Stack;

public class code_71 {
    public static void main(String[] args){
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }


    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] sList = path.split("/");
        for (int i = 0 ;i<sList.length;i++){
            if (sList[i] == null || sList[i].length() == 0){
                continue;
            }
            if (sList[i].equals(".")){
                continue;
            }else if (sList[i].equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }

            }else {
                stack.push(sList[i]);
            }
        }
        String ret = "";
        if (stack.isEmpty()){
            return "/";
        }
        while (!stack.isEmpty()){
            ret = "/" + stack.pop()+ret;
        }
        return ret;
    }

}
