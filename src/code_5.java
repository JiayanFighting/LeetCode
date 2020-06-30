public class code_5 {
    public static void main(String[] args){
        String s = "cddb";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    // 方法一：每个字符向两边扩展 或者携手右边的字符向两边扩展
    // 时间复杂度O(n^2)
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0;i<s.length();i++) {
            int j = 1;
            // 以第i个字符为中心，向两边延申
            while (i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j)) {
                j++;
            }
            res = res.length() < 2*j-1 ? s.substring(i-j+1,i+j):res;
            
            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                j = 0;
                while (i-j >= 0 && i+1+j < s.length() && s.charAt(i-j) == s.charAt(i+1+j)) {
                    j++;
                }
                res = res.length() < 2*j ? s.substring(i-j+1,i+j+1) : res;
            }
        }
        return res;
    }


    public static String longestPalindrome_1(String s) {
        String result = "";
        for(int i = 0;i<s.length();i++){
            String ret = s.charAt(i)+"";
            for(int j = 1;j<s.length()-i;j++){
                if((i-j)>=0 && (i+j)<s.length()){
                    if(s.charAt(i-j) == s.charAt(i+j)){
                        ret = s.charAt(i-j)+ret+s.charAt(i+j);
                    }else {
                        break;
                    }
                }
            }
            if(ret.length() > result.length()){
                result = ret;
            }
        }

        for(int i = 0;i<s.length()-1;i++){
            if (s.charAt(i) == s.charAt(i+1)){
                String ret = s.charAt(i)+""+s.charAt(i+1);
                for(int j = 1;j<s.length()-i;j++){
                    if((i-j)>=0 && (i+1+j)<s.length()){
                        if(s.charAt(i-j) == s.charAt(i+1+j)){
                            ret = s.charAt(i-j)+ret+s.charAt(i+1+j);
                        }else {
                            break;
                        }
                    }

                }
                if(ret.length() > result.length()){
                    result = ret;
                }
            }

        }

        return result;
    }
}
