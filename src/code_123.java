import sun.applet.AppletResourceLoader;

public class code_123 {
    public static void main(String[] args){
        int[] prices = {1,2,3,4,5};
        int ret = maxProfit(prices);
        System.out.println(ret);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int total = 0;
        for (int i = 1;i<prices.length-1;i++){
            int left = maxProfitOnece(0,i,prices);
            int right = maxProfitOnece(i+1,prices.length-1,prices);
            total = Math.max(total,left+right);
        }
        total = Math.max(total,maxProfitOnece(0,prices.length-1,prices));
        return total;
    }

    // 前一段时间买一次 后一段时间买一次
    public static int maxProfitOnece(int begin,int end,int[] prices) {
        if (begin >= end ) return 0;
        int min = prices[begin],maxProfit = 0;
        for (int i = begin+1;i<=end;i++){
            if (prices[i] > min){
                maxProfit = Math.max(prices[i] - min,maxProfit);
            }else {
                min = prices[i];
            }
        }
        return maxProfit;
    }


}
