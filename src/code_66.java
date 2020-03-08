import java.time.format.SignStyle;

public class code_66 {

    public static void main(String[] args){
        int[] digits = {9,9,9,9,9};
        int[] ret = plusOne(digits);
        for (int i=0;i<ret.length;i++){
            System.out.print(ret[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        int ex = 1;
        for(int i = digits.length-1;i>=0;i--){
            digits[i] ++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }


    public static int[] plusOne_2(int[] digits) {
        int ex = 1;
        String str = "";
        for(int i = digits.length-1;i>=0;i--){
            int nex = digits[i] + ex;
            if (nex > 9){
                ex = 1;
            }else {
                ex = 0;
            }
            str = (nex%10)+ str;
        }
        if (ex == 1){
            str = ex+ str;
        }

        int[] res = new int[str.length()];
        for (int i = 0;i<res.length;i++){
            res[i] = str.charAt(i) - '0';
        }
        return res;
    }
}
