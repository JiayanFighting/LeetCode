public class code_8 {

    public static void main(String[] args){
        String str = "91283472332";
        int ret = myAtoi(str);
        System.out.println(ret);
    }

    public static int myAtoi(String str) {
        int ret = 0;
        str = str.trim();
        if (str.length() == 0){
            return ret;
        }
        int flag = 1;
        int start = 0;
        if (str.charAt(start) == '-'){
            flag = -1;
            start ++;
        }else if (str.charAt(start) == '+'){
            start ++;
        }
        for (int i = start ; i< str.length();i++){
            char c = str.charAt(i);
            if (c < '0' || c > '9'){//不是数字
                return ret*flag;
            }else{
                ret = ret * 10 + (c - '0');
            }
            //溢出判断
            if(flag>0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && ret > Integer.MAX_VALUE/10)
                return Integer.MAX_VALUE;
            if(flag>0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && ret == Integer.MAX_VALUE/10 && str.charAt(i+1)-'0' > Integer.MAX_VALUE%10)
                return Integer.MAX_VALUE;
            if(flag<0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && -ret < Integer.MIN_VALUE/10)
                return Integer.MIN_VALUE;
            if(flag<0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && -ret == Integer.MIN_VALUE/10 && -(str.charAt(i+1)-'0') < Integer.MIN_VALUE%10)
                return Integer.MIN_VALUE;

        }
        return ret*flag;
    }
}
