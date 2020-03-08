public class code_96 {
    public static void main(String[] args){
        int n = 3;
        int ret = numTrees(n);
        System.out.println(ret);
    }

    public static int numTrees(int n) {
        if (n<=0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i =2 ;i<=n;i++){
            for (int j = 1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    // 递归 超出时间限制
    public static int numTrees2(int n) {
        if (n<=0) return 0;
        if (n == 1) return 1;
        int sum = 0;
        for (int i = 1;i<=n;i++){
            int left = helper(1,i-1);
            int right = helper(i+1,n);
            sum += left*right;
        }
        return sum;
    }

    public static int helper(int begin,int end){
        if (begin == end) return 1;
        if (begin > end) return 1;
        int sum = 0;
        for (int i = begin;i<=end;i++){
            int left = helper(begin,i-1);
            int right = helper(i+1,end);
            sum += left * right;
        }
        return sum;
    }



}
