public class code_151 {
    public static void main(String[] args){
        System.out.println(reverseWords("  hello world!  "));
    }

    //Hashset
    public static String reverseWords(String s) {
        //删除首位的空格
        int begin = 0,end = s.length()-1;
        while (begin <s.length()){
            if (s.charAt(begin) ==' ') begin++;
            else break;
        }
        while (end >= begin){
            if (s.charAt(end) ==' ') end --;
            else break;
        }
        s = s.substring(begin,end+1);
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length-1;i>=0;i--){
            if (!ss[i].equals("")){
                sb.append(ss[i]);
                if (i > 0){
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
