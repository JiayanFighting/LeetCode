import java.util.ArrayList;
import java.util.List;

public class code_119 {
    public static void main(String[] args){
        int n = 0;
        List<Integer> res = generate(n);
//        for (List<Integer> list:res){
            for (int num:res){
                System.out.print(num+" ");
            }
            System.out.println();
//        }
    }

    public static List<Integer> generate(int numRows) {
        List<Integer> list = new ArrayList<>();
        if (numRows < 0) {
            return list;
        }
        list.add(1);
        List<Integer> prelist = list;
        while (numRows > 0){
            list = new ArrayList<>();
            list.add(1);
            for (int i=0;i<prelist.size()-1;i++){
                list.add(prelist.get(i)+prelist.get(i+1));
            }
            list.add(1);
            numRows --;
            prelist = list;
        }
        return list;
    }

    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows <= 0){
            return ret;
        }
        List<Integer> alist = new ArrayList<>();
        alist.add(1);
        ret.add(new ArrayList<>(alist));
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        for (int i = 1;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            dp[i][0] = 1;
            for (int j = 1;j<i;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                list.add(dp[i][j]);
            }
            dp[i][i] = 1;
            list.add(1);
            ret.add(new ArrayList<>(list));
        }
        return ret;
    }


}
