import java.util.List;

public class code_60 {

    public static void main(String[] args){
        int n = 10;
        int k = 3;
        String ret = getPermutation(n,k);
        System.out.println(ret);
    }

    public static String getPermutation(int n, int k) {
        String str = "";
        return str;
    }

    public static void process(int dept,int now, int n, int k, List<Integer> list){
        if (dept == n){
            now = now+1;
            return;
        }
        if (now == k){
            return;
        }

        for (int i= 0;i<=n;i++){
            list.add(i);

            list.remove(list.size()-1);
        }
    }
}
