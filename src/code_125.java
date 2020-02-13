public class code_125 {

    public static void main(String[] args){
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1){
            return true;
        }
        s = s.toLowerCase();
        int left = 0,right = s.length()-1;
        while (left <= right){
            // 65-90 97-122 数字 48-57
            if (s.charAt(left) < 48 || s.charAt(left) > 122 || (s.charAt(left) >57 && s.charAt(left)<97)){
                left++;
                continue;
            }
            if (s.charAt(right) < 48 || s.charAt(right) > 122 || (s.charAt(right) >57 && s.charAt(right)<97)){
                right--;
                continue;
            }

            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            System.out.println(s.charAt(left));
            System.out.println(s.charAt(right));
            left ++;
            right--;
        }
        return true;
    }
}
