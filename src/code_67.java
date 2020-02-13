public class code_67 {
    public static void main(String[] args){
        String a = "111111";
        String b = "10";
        System.out.println(addBinary(a,b));
    }

    public static String addBinary(String a, String b) {
        if (a.length() == 0 && b.length() == 0) return "0";
        if (a.length() == 0) return b;
        if (b.length() == 0) return a;
        String ret = "";
        int k = 1;//倒数第 k个
        int add = 0;
        while (a.length()-k >= 0 && b.length()-k >=0){
            int num = a.charAt(a.length()-k)-48 + b.charAt(b.length()-k)-48 + add;
            ret = num % 2 + ret;
            add = num / 2;
            k++;
        }
        while (a.length()-k >= 0){
            int num = a.charAt(a.length()-k)-48 + add;
            ret = num % 2 + ret;
            add = num / 2;
            k++;
        }
        while (b.length()-k >= 0){
            int num = b.charAt(b.length()-k)-48 + add;
            ret = num % 2 + ret;
            add = num / 2;
            k++;
        }
        if (add != 0 ) ret = add + ret;
        return ret;
    }


}
