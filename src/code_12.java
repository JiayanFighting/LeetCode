import java.util.HashMap;

public class code_12 {
    public static void main(String[] args){
        int num = 3;
        String result =  intToRoman(num);
        System.out.println(result);
    }

    public static String intToRoman(int num) {
        int[] number= {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] c = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        String result = "";

        for (int i= number.length-1;i>=0;i--){
            while (num >= number[i]){
                result += c[i];
                num-=number[i];
            }
        }
        return result;
    }
}
