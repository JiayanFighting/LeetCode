public class code_201 {
    public static void main(String[] args){
        //   1 0 1
        //   1 1 0
        //   1 1 1

        //   1 0 0
        System.out.println(rangeBitwiseAnd(5,7));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int sum = 0;
        for (int i = 1;i<=32;i++){
            int num = (m & 1) & (n & 1);
            sum = sum<<1 + num;
            m = m>>1;
            n = n>>1;
        }
        return sum;
    }


}
