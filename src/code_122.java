public class code_122 {
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int ret = maxProfit(prices);
        System.out.println(ret);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int total = 0;
        for (int i = 1;i<prices.length;i++){
            if (prices[i] > prices[i-1]){
                total += prices[i]-prices[i-1];
            }
        }

        return total;
    }


}
