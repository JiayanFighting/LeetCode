public class code_233 {
    public static void main(String[] args){
        System.out.println(countDigitOne(13));
    }

    // 数字1的个数
    // 暴力法 超时
    public static int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int x = 0;
            int k = i;
            while (k >= 1) {
                x = k % 10;
                k = k / 10;
                if (x == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
