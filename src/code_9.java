public class code_9 {
    public static void main(String[] args){
        int x = 100;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        if (x <  0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int y = 0;
        while (y < x) {
            y = y*10+x % 10;
            x = x / 10;
        }
        return x == y || x == y/10;
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
