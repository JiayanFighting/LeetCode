public class code_28 {
    public static void main(String [] args){
        String haystack = "mississippi";
        String needle = "pi";
        int ret = strStr(haystack,needle);
        System.out.println(ret);
    }

    //KMP


    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()){
            return  -1;
        }
        if (needle.length() == haystack.length()){
            if (needle.equals(haystack)){
                return 0;
            }else {
                return -1;
            }
        }
        for (int i =0;i<haystack.length()-needle.length()+1;i++){
            boolean flag = true;
            for (int j =0;j<needle.length();j++){
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }

        return -1;
    }
}
