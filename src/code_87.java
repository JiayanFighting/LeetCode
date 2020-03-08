public class code_87 {
    public static void main(String[] args){
        String s1 = "great";
        String s2 = "rgtae";
        boolean ret = isScramble(s1,s2);
        System.out.println(ret);
    }

    public static  boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        for (int i = 0;i<s1.length();i++){
            isScramble(s1.substring(0,i),s2.substring(0,i));
        }
        return false;
    }


}
