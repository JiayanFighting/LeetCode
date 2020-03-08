import java.util.ArrayList;
import java.util.List;

public class code_89 {
    public static void main(String[] args){
        List<Integer> ret = grayCode(2);
        for (int num:ret){
            System.out.print(num+" ");
        }
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if (n == 0) return list;
        for (int i = 1;i<=n;i++){
            int size = list.size();
            for (int j = size-1;j>=0;j--){
                int num = list.get(j);
                int newnum = num + (1<<(i-1));
                list.add(newnum);
            }
        }
        return list;
    }


}
