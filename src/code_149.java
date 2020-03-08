import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class code_149 {
    public static void main(String[] args) {
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(points));
    }

    //
    public static int maxPoints(int[][] points) {
        if (points.length == 0 || points[0].length != 2) return 0;
        if (points.length == 1){
            return 1;
        }
        if (points.length == 2) return 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0;i<points.length;i++){
            for (int j = i+1;j<points.length;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                double k = (double)(y2-y1)/(x2-x1);
                double b = y1-k*x1;
                int key = Double.valueOf(k).hashCode() + Double.valueOf(b).hashCode();
                int num = map.getOrDefault(key,0);
                num ++ ;
                map.put(key,num);
                max = Math.max(max,num);
            }
        }
        // max = res*(res-1)/2
        int left = 1,right = max;
        while (left <= right){
            int mid = (left + right)/2;
            if ((double)mid /2- (double)1/2 == (double)max/mid){
                return mid;
            }else if ((double)mid /2- (double)1/2 < (double)max/mid){
                left++;
            }else {
                right--;
            }
        }

        return max;
    }
}
