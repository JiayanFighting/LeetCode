public class code_135 {
    public static void main(String[] args){
        int[] ratings = {2,1,0,1,5,4,2,1,4};
//        int[] ratings = {1,0,2};
        //               1 1 1 1 1 1 1 1 1
        //               2 1 0 1 3 2 1 0 1
        //               3 2 1 2 4 3 2 1 2
        int ret = candy(ratings);
        System.out.println(ret);
    }

    public static int candy(int[] ratings){
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int[] record = new int[ratings.length];
        // 向左一遍
        for (int i = 0;i<ratings.length-1;i++){
            if (ratings[i] < ratings[i+1] && record[i] >= record[i+1]){
                record[i+1] = record[i]+1;
            }
        }
        //向右一遍
        for (int j = ratings.length-1;j>0;j--){
            if (ratings[j-1] > ratings[j] && record[j-1] <= record[j]){
                record[j-1] = record[j] + 1;
            }
        }
        int res = ratings.length;
        for (int i=0;i<record.length;i++){
            res += record[i];
        }
        return res;
    }



    public static int candy2(int[] ratings) {
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int res = ratings.length;
        int[] dp = new int[ratings.length];
        for (int i =0;i< ratings.length;i++){
            for (int left = i-1;left >=0;left--){
                // left left+1
                if (ratings[left] < ratings[left+1]){
                    break;
                }
                if (ratings[left] > ratings[left+1] && dp[left] <= dp[left+1]){
                    dp[left]++;
                    res++;
                }
            }
            for (int right = i+1;right<ratings.length;right++){
                // right-1 right
                if (ratings[right] < ratings[right-1]){
                    break;
                }
                if (ratings[right] > ratings[right-1] && dp[right] <= dp[right-1]){
                    dp[right] ++;
                    res++;
                }
            }
        }
        return res;
    }


}
