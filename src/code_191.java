public class code_191 {
    public static void main(String[] args){
        System.out.println(hammingWeight(9));
    }

    // 二进制中1的个数
    public static int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
