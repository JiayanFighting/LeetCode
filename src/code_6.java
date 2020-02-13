import java.util.ArrayList;

public class code_6 {
    public static void main(String[] args){
        String s = "ABCDEF";
       // String s = "L";LCIRETOESIIGEDHN  LDREOEIIECIHNTSG
        int numRows = 5;
        String result = convert(s,numRows);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }
        int len = s.length();
        int len_2 = (int)Math.ceil((double)(len) /(double)(2*numRows-2))+1;
        int[] firstr = new int[len_2];
        String result = "";
        for (int i =0 ;i<len_2;i++){
            firstr[i] = (2*numRows -2)*i ;
            if(firstr[i] < s.length()){
                result += String.valueOf(s.charAt(firstr[i]));
            }
        }
        int taget = 0;
        for (int r = 1;r<=numRows-2;r++){
            for(int lie = 0;lie < len_2;lie ++){
                taget = firstr[lie]-r;
                if(taget > 0 && taget < s.length()){
                    result += String.valueOf(s.charAt(taget));
                }
                taget = firstr[lie]+r;
                if(taget > 0 && taget < s.length()){
                    result += String.valueOf(s.charAt(taget));
                }
            }
        }
        for(int lie = 0;lie < len_2;lie ++) {
            taget = lie*(2*numRows-2)+numRows-1;
            if(taget > 0 && taget < s.length()){
                result += String.valueOf(s.charAt(taget));
            }
        }
        return result;
    }

}
