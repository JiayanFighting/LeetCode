public class code_70 {
    public static void main(String[] args){
        int n = 10;
        int ret = climbStairs(n);
        System.out.println(ret);
    }


    public static int climbStairs(int n) {
        int[] ret = new int[n];
        ret[0] = 1;
        ret[1] = 2;
        for (int i = 2;i<n;i++){
            ret[i] = ret[i-1]+ret[i-2];
        }
        return ret[n-1];
    }
}
