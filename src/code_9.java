public class code_9 {
    public static void main(String[] args){
        int x = 12344321;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = 0;
        while (x>num){
            num = num*10 + x%10;
            x = x/10;
        }
        return x == num || x == num/10;
    }

    // 转换为字符串 再判断是否是回文字符串
    public static boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        int i = 0;
        int j = s.length()-1-i;
        while(i<=j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
