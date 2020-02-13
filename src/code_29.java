public class code_29 {
    public static void main(String [] args){
        int dividend = -2147483648;
        int divisor = -1;
        int ret = divide(dividend,divisor);
        System.out.println(ret);
    }

    public static int divide(int dividend, int divisor) {
        boolean fu = false;
        if ((dividend < 0 && divisor>0) || (dividend > 0 && divisor<0)){
            fu = true;
        }
        int ret = -1;
        if (dividend == -2147483648){
            if (divisor == -2147483648){
                return 1;
            }
            divisor = (-1)*Math.abs(divisor);
            while (dividend <= divisor){
                dividend = dividend - divisor;
                ret++;
            }
            if (fu ||ret != 2147483647){
                ret ++;
            }
            ret = fu? (-1)*ret : ret;
        }else{
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
            while (dividend >= divisor){
                dividend = dividend -divisor;
                ret++;
            }
            if (ret != 2147483647){
                ret ++;
            }
            ret = fu? (-1)*ret : ret;
        }
        return ret;
    }
}
