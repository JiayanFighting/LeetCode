public class code_7 {
    public static void main(String[] args){
        int x = -123; //2147483647  -2147483648
        int ret = reverse(x);
        System.out.println(ret);
    }

    public static int reverse(int x) {
        int flag = 1;
        if (x < 0){
            flag = 0;
        }
        int ret = 0;
        x = Math.abs(x);
        while (x > 0){
            if (flag == 0){
                if(ret < (-2147483648 + x%10)/10){
                    return 0;
                }
                ret = ret * 10 - x%10;
            }else{
                if(ret > (2147483647 - x%10)/10){
                    return 0;
                }
                ret = ret * 10 + x%10;
            }
            x = x /10;
        }
        return ret;
    }
}
