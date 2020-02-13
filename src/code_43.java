public class code_43 {
    public static void main(String[] args){

        String num2 = "9999999999999";
        String num1 = "0";
        System.out.println(multiply(num1,num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "0";
        String lastResult = "0";
        for (int i = num1.length()-1;i>=0;i--){
            //num1[i] * num2
            int add = 0;
            String s = "";
            for (int j = num2.length()-1;j>=0;j--){
                int num = (num2.charAt(j)-48) * (num1.charAt(i)-48);
                num += add;
                s  = num %10 + s;
                add = num /10;
            }
            if (add != 0 ){
                s  = add + s;
            }
            System.out.println(s);
            lastResult = getAddResult(lastResult,s,num1.length()-i-1);
            System.out.println(lastResult);
        }
        int index = 0;
        while (lastResult.length()>1 && index < lastResult.length()&&lastResult.charAt(index) =='0'){
            lastResult = lastResult.substring(index+1);
        }
        return lastResult;
    }

    public static String getAddResult(String s1 ,String s2,int zeronum){
        // s1 + s2 *10
        while (zeronum > 0){
            s2 +="0";
            zeronum--;
        }
        String ret = "";
        System.out.println("s1="+s1+",s2="+s2);
        int offset = 1,add = 0; //offset 倒数第 offset 个
        while (s1.length()-offset >= 0 && s2.length()-offset >= 0){
            int index1 = s1.length()-offset , index2 = s2.length()-offset;
            int num = s1.charAt(index1)-48 + s2.charAt(index2) - 48 + add;
            ret = num % 10 + ret;
            add = num /10;
            offset ++;
        }
        if (s1.length()-offset>=0){ // s1更大
            while (s1.length()-offset >= 0){
                int index1 = s1.length()-offset;
                int num = s1.charAt(index1) - 48 + add;
                ret = num % 10 + ret;
                add = num /10;
                offset ++;
            }

        }else {
            while (s2.length()-offset >= 0){
                int index2 = s2.length()-offset;
                int num = s2.charAt(index2) - 48 + add;
                ret = num % 10 + ret;
                add = num /10;
                offset ++;
            }
        }
        if (add != 0){
            ret = add + ret;
        }
        return ret;
    }


}
