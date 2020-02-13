import javax.print.DocFlavor;

public class code_14 {
    public static void main(String[] args){
        String[] strs = {"flower","flow","flowwight"};
        String ret = longestCommonPrefix(strs);
        System.out.println(ret);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0){
            return "";
        }else if (strs.length == 1){
            return strs[0];
        }
        return getLongestPrefix(strs , 0,strs.length-1);
    }

    public static String getLongestPrefix(String[] strs , int begin,int end){
        if (begin > end || strs == null){
            return  "";
        }
        if (end == begin){
            return strs[begin];
        }
        int middle = (begin + end ) /2;
        String a = getLongestPrefix(strs , begin , middle);
        String b = getLongestPrefix(strs , middle+1 , end);
        String ret = getMaxPre( a , b);
        return ret;
    }

    public static String getMaxPre(String a ,String b){
        String ret = "";
        int point = 0;
        while (point< a.length() && point <b.length()){
            if (a.charAt(point) != b.charAt(point)){
                break;
            }else {
                ret = ret + a.charAt(point);
                point++;
            }
        }
        return  ret;
    }
}
