import java.util.ArrayList;
import java.util.List;

public class code_60 {

    public static void main(String[] args){
        int n = 3;
        int k = 6;
//        "123"
//        "132"
//        "213"
//        "231"  4
//        "312"
//        "321"
        String ret = getPermutation(n,k);
        System.out.println(ret);
    }

    public static String getPermutation(int n, int k) {
        boolean[] record = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        helper(n,n,k,record,list);
        StringBuilder sb = new StringBuilder();
        for (int num:list){
            sb.append(num);
        }
        return sb.toString();
    }

    public static int helper(int left ,int n, int k,boolean[] record,List<Integer> list){
        if ( left == 0){
            k--;
            return k;
        }

        for (int i = 1;i<=n;i++){
            if (!record[i]){
                record[i] = true;
                list.add(i);
                k = helper(left-1,n,k,record,list);
                if (k == 0){
                    return k;
                }
                record[i] = false;
                list.remove(list.size()-1);
            }
        }
        return k;
    }

    public static int nFactorial(int n){
        if (n == 1) return 1;
        return nFactorial(n-1)*n;
    }


}
