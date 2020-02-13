public class code_50 {
    public static void main(String[] args){
        double x = 2.1;
        int n = 3;
        double ret = myPow(x,n);
        System.out.println(ret);
    }

    public static double myPow(double x, int n) {
        double ret = 1;
        if (n == 0){
            return ret;
        }
        if (n == 1){
            return x;
        }
        double half = myPow(x,Math.abs(n/2));
        ret = half *half;
        if (Math.abs(n) % 2 != 0){
            ret *=x;
        }
        if (n<0){
            ret = (double)1/ret;
        }
        return  ret;
    }
}
