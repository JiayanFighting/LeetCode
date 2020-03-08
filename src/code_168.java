public class code_168 {
    public static void main(String[] args){
        System.out.println(convertToTitle(703));
    }

    public static String convertToTitle(int n){
        StringBuilder sb = new StringBuilder();
        n--;
        while (n >= 0 ){
            int num = n % 26;
            char c = (char)(num + 65);
            sb.insert(0,c);
            n = n / 26;
            n--;
        }
        return sb.toString();
    }
}
