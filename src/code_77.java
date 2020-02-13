import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class code_77 {
    public static void main(String[] args){
        int n = 4;
        int k = 2;
        List<List<Integer>> res = combine(n,k);
        for (List<Integer> list:res){
            for (int num:list){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n<1||k<1){
            return res;
        }
        List<Integer> list = new ArrayList<>();
        process(1,k,n,list,res);
        return res;
    }

    public static void process(int start,int k,int n,List<Integer> list,List<List<Integer>> res){
        if (k<0){
            return;
        }
        if (k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        // 剪枝：i <= n - (k - p.size()) + 1
        for (int i = start;i<=n;i++){
            list.add(i);
            process(i+1,k-1,n,list,res);
            list.remove(list.size()-1);
        }
    }


}
