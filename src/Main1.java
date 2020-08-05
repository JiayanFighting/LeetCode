import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0,"0000");
        map.put(1,"0001");
        map.put(2,"0010");
        map.put(3,"0011");
        map.put(4,"0100");
        map.put(5,"0101");
        map.put(6,"0110");
        map.put(7,"0111");
        map.put(8,"1000");
        map.put(9,"1001");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        getNewCode(nums,map);

    }

    public static void getNewCode(int[] nums,HashMap<Integer,String> map){
        for (int num:nums){
            String s = toBinary(num,map);
            String res = revert(s);
            System.out.println(res);
        }
    }


    public static String revert(String s){
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i>=0; i--){
            if (flag && s.charAt(i) == '0'){
                continue;
            }
            sb.append(s.charAt(i));
            flag = false;
        }
        return sb.toString();
    }
    public static String toBinary(int num,HashMap<Integer,String> map){
        String res = "";
        int count = 0;
        while (num > 0){
            int x = num % 10;
            res = map.get(x)+res;
            count++;
            num = num/10;
        }
        while (count < 3){
            res = map.get(0)+res;
            count++;
        }
        return res;
    }
}
