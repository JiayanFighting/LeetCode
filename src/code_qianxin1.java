import java.math.BigDecimal;
import java.util.Scanner;

public class code_qianxin1 {
    public static void main(String[] args){
        System.out.print(makeBaby(100));
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
//
//        // 1000 10  取num
//        // 1- Cnum 990 / C num 100
//        double ret = helper(num);
//        System.out.print(String.format("%.6f",ret));
    }

    public static double helper(int num){
        if (num <= 0) return 0;
        if (num > 990) return 1;
        double sum = 1;
        BigDecimal sum1 = new BigDecimal("1") ;
        BigDecimal sum2 = new BigDecimal("1") ;
        if (num <= 10){
            for (int i =0;i<num;i++){
                String s = 990-i+"";
                sum1 = sum1.multiply(new BigDecimal(s));
                s = 1000-i+"";
                sum2 = sum2.multiply(new BigDecimal(s));
                //sum *=(double) (990-i)/(double)(1000-i);
            }
            return 1.0-sum1.doubleValue()/sum2.doubleValue();
        }else {
            for (int i = 0;i<10;i++){
                String s = 1000 - num - i+"";
                sum1 = sum1.multiply(new BigDecimal(s));
                s = 1000-i+"";
                sum2 = sum2.multiply(new BigDecimal(s));
//                sum *= (double) (1000 - num - i) /(double)(1000-i);
            }
            return 1.0-sum1.doubleValue()/sum2.doubleValue();
        }
    }

    public static double helper2(int num){
        if (num <= 0) return 0;
        if (num > 990) return 1;
        double sum = 1;
        if (num <= 10){
            for (int i =0;i<num;i++){
                //sum *=(double) (990-i)/(double)(1000-i);
                sum = sum * (1-(double)10/(1000-i));
            }
            return 1.0-sum;
        }else {
            for (int i = 0;i<10;i++){
//                sum *= (double) (1000 - num - i) /(double)(1000-i);
                sum = sum * (1-(double)num/(1000-i));
            }
            return 1.0-sum;
        }
    }

    public static int makeBaby(int n ){
        if (n<=0) return 0;
        if (n<=4) return 1;
//        int[] dp = new int[n+1];
        int num1 = 1,num2= 1,num3= 1,num4=1;
//        return makeBaby(n-1)+makeBaby(n-4);
//        dp[0] = 0;
//        for (int i = 1;i<=4;i++){
//            dp[i] = 1;
//        }
        int ret = 1;
        for (int i = 5;i<=n;i++){
//        不会死
//         4个月之前生的兔子开始生兔子
            ret = num1 + num4;
            num4 = num3;
            num3 = num2;
            num2 = num1;
            num1 = ret;
            System.out.println(ret);
//            dp[i] = dp[i-1]+dp[i-4];
        }
        return ret;
    }
}
