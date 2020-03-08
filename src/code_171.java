public class code_171 {
    public static void main(String[] args){
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s){
        int times = 0, ret = 0;
        for (int i = s.length()-1;i>=0;i--){
            ret += ( s.charAt(i)-64) * Math.pow(26,times);
            times ++;
        }
        return ret;
    }
}
