public class code_69 {
    public static void main(String[] args){
        int ret = mySqrt(9);
        System.out.println(ret);
    }

    public static int mySqrt(int x) {
        if (x <= 0) return 0;
        int left = 1,right = x;
        while (left<=right){
            int mid = (left + right) /2;
            // mid * mid 会超过Integer.MAX_VALUE
            if ((float)mid <= (float)x/(float)mid && (float)(mid+1) >(float) x /(float)(mid+1)){
                return mid;
            }else if ((float)mid  > (float)x/(float)mid){
                right = mid-1;
            }else {
                left = mid +1;
            }
        }
        return 0;
    }

}
