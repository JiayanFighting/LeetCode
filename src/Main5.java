import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        // 都为负数 表示 花钱换空间
        // weight + value 负，又占空间还废钱，直接淘汰
        //weight - value+,又增加空间，又增加收益，直接入选。
        ArrayList<Integer> reWeight = new ArrayList<>();
        ArrayList<Integer> reValue = new ArrayList<>();

        ArrayList<Integer> reWeightfu = new ArrayList<>();
        ArrayList<Integer> reValuefu = new ArrayList<>();

        int baseValue = 0;
        int maxm = m;
        for (int i = 0;i<n;i++){
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
            if (weight[i] >= 0 && value[i]>=0){
                reWeight.add(weight[i]);
                reValue.add(value[i]);
            }else if (weight[i]<=0 && value[i]>=0){
                m -= weight[i];
                maxm -= weight[i];
                baseValue += value[i];
            }else if (weight[i] < 0 && value[i] <0){
                reWeightfu.add(weight[i]);
                reValuefu.add(value[i]);
                maxm -= weight[i];
            }
        }
//        System.out.println(getResult(n,m,weight,value));
        System.out.println(getResult2(m,maxm,reWeight,reValue,reWeightfu,reValuefu)+baseValue);
    }

    public static int getResult2(int m,int maxm,ArrayList<Integer> reWeight,ArrayList<Integer> reValue,ArrayList<Integer> reWeightfu ,ArrayList<Integer> reValuefu){
        int n = reWeight.size();
        // 背包容量剩余j时 第i个的最大价值
        int[][] dp = new int[n+1][maxm+1];
        for (int i = 1;i<=n;i++){
            for (int j = 0;j<=m;j++){
                if (reWeight.get(i-1) > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-reWeight.get(i-1)]+reValue.get(i-1));
                }
            }
            for (int k = m+1;k<=maxm;k++){
                dp[i][k] = dp[i][k-1];
            }

            for (int l = 0;l<reWeightfu.size();l++){
                int newm = m-reWeightfu.get(l);
                for (int k = m+1;k<=newm;k++){
                    // 要花钱和不要花钱
                    // 要花钱
                    if (reWeight.get(i-1) > k){
                        int newmoney = dp[i-1][k];
                        dp[i][k] = Math.max(dp[i][k],newmoney);
                    }else{
                        // 花钱
//                        System.out.println(dp[i-1][k]);
//                        System.out.println(dp[i-1][k-reWeight.get(i-1)]);
                        int newmoney = Math.max(dp[i-1][k],dp[i-1][k-reWeight.get(i-1)]+reValue.get(i-1))+reValuefu.get(l);
                        dp[i][k] = Math.max(dp[i][k],newmoney);
                    }
                }
            }
        }


        return dp[n][maxm];
    }

    public static int getResult(int n,int m,int[] weight,int[] value){
        // 背包容量剩余j时 第i个的最大价值
        int[][] dp = new int[n+1][m+1];
        for (int i = 1;i<=n;i++){
            for (int j = 0;j<=m;j++){
                if (weight[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        return dp[n][m];
    }
}
