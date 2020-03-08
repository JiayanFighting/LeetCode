public class code_190 {
    public static void main(String[] args){
        System.out.println(reverseBits(9));
    }

    // 二进制中1的个数
    public static int reverseBits(int n)  {

        int ans = 0;
        for (int i = 31;n != 0; n = n >>> 1,i--){
            ans += (n & 1) << i;
        }
        return ans;
    }
}
