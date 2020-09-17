import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> weight = new ArrayList<>();
        ArrayList<Integer> value = new ArrayList<>();
        int base = 0;
        for (int i = 0;i<n;i++){
            int w = sc.nextInt();
            int v = sc.nextInt();
            if (w >= 0 && v>=0){
                weight.add(w);
                value.add(v);
            }else if (w<=0 && v>=0){
                m -= w;
                base += v;
            }
        }
        n = weight.size();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1;i<=n;i++){
            for (int j = 0;j<=m;j++){
                if (weight.get(i-1) > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight.get(i-1)]+value.get(i-1));
                }
            }
        }
        System.out.println(dp[n][m]+base);
    }
}
