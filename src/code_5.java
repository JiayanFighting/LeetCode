public class code_5 {
    public static void main(String[] args){
        String s = "abcbaaaa";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
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
