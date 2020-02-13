public class code_88 {
    public static void main(String[] args){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m =3;
        int n = 3;
        merge(nums1,m,nums2,n);
        for (int i = 0;i<m+n;i++){
            System.out.print(nums1[i]);
        }
        System.out.println();

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n)  {
        int index = m+n-1;
        int index1 = m-1 , index2 = n-1;
        while (index1 >= 0 && index2 >= 0){
            if (nums1[index1] <= nums2[index2]){ //2更大，2添加到index中
                nums1[index] = nums2[index2];
                index --;
                index2--;
            }else { // 1更大，1往后移
                nums1[index] = nums1[index1];
                index --;
                index1 --;
            }
        }
        while (index2 >= 0){
            nums1[index] = nums2[index2];
            index --;
            index2--;
        }
    }


}
