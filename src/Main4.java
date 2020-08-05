import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int m = sc.nextInt();
        getResult(s,m);
    }

    public static void getResult(int s,int m) {
        double pro = 0;
        double min = s;
        double max = s;
        int lastmaxnum = 1;
        int maxleft = 1;
        int count = 0;
        while (pro < m && max > 1){
            double[] d = getMaxValue(max);
            count ++;
            pro += d[1];
            maxleft --;
            min = Math.min(min,d[0]);
            if (maxleft <= 0){
                maxleft = lastmaxnum*2;
                lastmaxnum = maxleft;
                max = min;
            }

        }
        if (pro < m){
            System.out.println(-1);
        }else {
            System.out.println(count);
        }
    }

    public static void helper(){

    }

    public static double[] getMaxValue(double k){
        double[] res = new double[2];
        res[0] =  k/2;
        res[1] = k*k/4;
        return res;
    }
}
