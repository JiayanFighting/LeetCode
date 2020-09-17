import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[m];
        for (int i=0;i<m;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(getResult2(n,m,nums));
    }

    public static int getResult(int n,int m,int[] nums){
        if (nums[0] == 1){
            return n;
        }
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        int multi = 1;
        while (multi*nums[0]<= n){
            for (int num:nums) {
                if (num * multi <= n){
                    set.add(num*multi);
                }
            }
            multi++;
        }
        return set.size();
    }

    public static int getResult2(int n,int m,int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;i<nums.length;i++){
            int num = n/ nums[i];
            for (int j =1;j<=num;j++){
                set.add(j*nums[i]);
            }
        }
        return set.size();
    }

    public static int getResult3(int n,int m,int[] nums){
        int count = 0;
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=nums.length-1;i>=0;i--){
            list.add(nums[i]);
            for (int j = 0;j<i;j++){
                if (nums[i]%nums[j] == 0){
                    list.remove(list.size()-1);
                    break;
                }
            }
        }

        for (int i = 0;i<nums.length;i++){
            int num = n/ nums[i];
            count+=num;
        }

        for (int i =0;i<nums.length;i++){

        }


        return set.size();
    }


}


