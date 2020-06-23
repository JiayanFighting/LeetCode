import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] sList = new String[n];
        for (int i = 0;i<n;i++){
            sList[i] = sc.next();
        }
        String[] ret = getResult(n,sList);
        for (String s :ret){
            System.out.println(s);
        }
    }

    public static String[] getResult(int n,String[] sList){
        for (int i = 0;i<n;i++){
            sList[i] = check(sList[i]);
        }
        return sList;
    }

    public static String check(String s){
        if (s.length() <= 2) return s;
        StringBuilder sb = new StringBuilder();
//        sb.append(s.charAt(0));
        int last = 0;
        int num = 1;
        for (int i = 1;i<s.length();i++){
            if (s.charAt(i) == s.charAt(i-1)){
                num ++;
            }else { // 与前面的不同，需要判断
                int tmp = num;
                if (last == 2 && num >= 2){//aabb
                    sb.append(s.charAt(i-1)); // 只保留一个
                    tmp = 1;
                }else if (num >= 3){//aaa
                    sb.append(s, i-2, i);
                    tmp = 2;
                }else {
                    sb.append(s,i-num,i);
                }
                num = 1;
                last = tmp;
            }
        }
        int tmp = num;
        if (last == 2 && num >= 2){//aabb
            sb.append(s.charAt(s.length()-1)); // 只保留一个
            tmp = 1;
        }else if (num == 3){//aaa
            sb.append(s, s.length()-2, s.length());
            tmp = 2;
        }else {
            sb.append(s,s.length()-num,s.length());
        }
        num = 1;
        last = tmp;

        return sb.toString();
    }
}
