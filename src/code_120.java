import java.util.ArrayList;
import java.util.List;

public class code_120 {
    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        triangle.add(list);
        list = new ArrayList<>();
        list.add(-2);
        list.add(-3);
        triangle.add(list);
//        list = new ArrayList<>();
//        list.add(6);
//        list.add(5);
//        list.add(7);
//        triangle.add(list);
//        list = new ArrayList<>();
//        list.add(4);
//        list.add(1);
//        list.add(8);
//        list.add(3);
//        triangle.add(list);
        for (List<Integer> list2:triangle){
            for (int num:list2){
                System.out.print(num+" ");
            }
            System.out.println();
       }
        int ret = minimumTotal(triangle);
        System.out.println(ret);
    }



    //动态规划
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        int sum = triangle.get(0).get(0);
        int min = sum;
        List<Integer> prelist = triangle.get(0);
        int rowNum = 1;
        while (rowNum < triangle.size()){
            List<Integer> list = triangle.get(rowNum);
            List<Integer> newList = new ArrayList<>();
            //第一个
            sum = list.get(0) + prelist.get(0);
            newList.add(sum);
            min = sum;
            //中间
            for (int j=1;j<list.size()-1;j++){
                sum = list.get(j) + Math.min(prelist.get(j-1),prelist.get(j));
                min = Math.min(min,sum);
                newList.add(sum);
            }
            //最后一个
            sum = list.get(list.size()-1) + prelist.get(prelist.size()-1);
            min = Math.min(min,sum);
            newList.add(sum);
            prelist = newList;
            rowNum++;
        }
        return min;
    }


    //超时
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0){
            return 0;
        }
        return helper(0,0,0,triangle);

    }
    public static int helper(int listnum , int sum ,int index, List<List<Integer>> lists){
        // 当前行 当前sum 当前index
        if (listnum == lists.size()-1){
            return sum+lists.get(listnum).get(index);
        }
        List<Integer> list = lists.get(listnum);
        sum = Math.min(helper(listnum+1 , sum+list.get(index),index,lists), helper(listnum+1 , sum+list.get(index),index+1,lists));
        return sum;
    }
}
