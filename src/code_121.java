public class code_121 {
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int ret = maxProfit(prices);
        System.out.println(ret);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1;i<prices.length;i++){
            if (prices[i] > prices[i-1]){
                dp[i] = Math.max(dp[i-1] , prices[i] - min);
            }else {
                dp[i] = dp[i-1];
            }
            min = Math.min(min,prices[i]);
        }

        return dp[prices.length-1];
    }


}
