public class code_58 {

    public static void main(String[] args){
        String s = "   ";
        int ret = lengthOfLastWord(s);
        System.out.println(ret);
    }

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0){
            return 0;
        }
        int ret = 0;
        for (int i = s.length()-1;i>=0;i--){
            if (s.charAt(i) == ' '){
                if (ret != 0){
                    return ret;
                }else {
                    continue;
                }
            }
            ret++;

        }
        return ret;
    }
}
