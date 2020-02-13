import sun.security.ec.point.AffinePoint;

public class code_80 {
    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int ret = removeDuplicates(nums);
        System.out.println(ret);
        for (int i = 0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        for (int i = 0;i<ret;i++){
            System.out.print(nums[i]+" ");
        }

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <=1){
            return nums.length;
        }
        int j = 1;
        int num = 1;
        for (int i = 1;i<nums.length;i++){
            if (nums[i] == nums[i-1]){
                num ++;
            }else {
                num = 1;
            }
            if (num <= 2){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }


    public static int removeDuplicates2(int[] nums) {
        if (nums.length <=1){
            return nums.length;
        }
        int len = nums.length;
        int num = 1;
        int last = 0;
        int index = 1;
        while (index < nums.length){
            if (nums[last] != nums[index]){
                if (last + 1 == index){
                    last = index;
                }else{
                    nums[last+1] = nums[index];
                    last++;
                }
                num = 1;
                index ++;
            }else{
                if (num < 2){
                    if (last + 1 < index){
                        nums[last+1] = nums[index];
                    }
                    last ++;
                    index++;
                    num++;
                }else{
                    last ++;
                    for (int i = index+1;i<nums.length;i++){
                        len--;
                        if (nums[i] != nums[last] ){
                            index = i;
                            break;
                        }
                    }
                    nums[last] = nums[index];
                    index++;
                    num = 1;
                }
            }
        }
        return last-1;
    }


}
