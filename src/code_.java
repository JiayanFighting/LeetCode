import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class code_ {
    public static void main(String[] args){
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.remove(1);
        ConcurrentHashMap<Integer,Integer> cmap = new ConcurrentHashMap<>();
        cmap.put(1,1);

    }
}


class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}
