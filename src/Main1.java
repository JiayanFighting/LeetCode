import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static int maxCount = 0;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String sBoy = sc.nextLine();
        String[] sBoys = sBoy.split(" ");
        HashSet<Integer> boys = new HashSet<>();
        int[] boyss = new int[sBoys.length];
        boolean[] rboy = new boolean[sBoy.length()];
        HashMap<Integer,Integer> boymap = new HashMap<>();
        int index = 0;
        for (String boy:sBoys){
            boys.add(Integer.parseInt(boy));
            boyss[index] = Integer.parseInt(boy);
            boymap.put(Integer.parseInt(boy),index);
            index++;
        }
        String sGirl = sc.nextLine();
        String[] sGirls = sGirl.split(" ");
        HashSet<Integer> girls = new HashSet<>();
        int[] girlss = new int[sBoys.length];
        boolean[] rgirl = new boolean[sGirl.length()];
        HashMap<Integer,Integer> girlmap = new HashMap<>();
        index = 0;
        for (String girl:sGirls){
            girls.add(Integer.parseInt(girl));
            girlss[index] = Integer.parseInt(girl);
            girlmap.put(Integer.parseInt(girl),index);
            index++;
        }
        int n = sc.nextInt();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();

        for (int i = 0;i<n;i++){
            int boy = sc.nextInt();
            int girl = sc.nextInt();
            if (map.containsKey(boy)){
                HashSet<Integer> set = map.get(boy);
                set.add(girl);
                map.put(boy,new HashSet<>(set));
            }else{
                HashSet<Integer> set = new HashSet<>();
                set.add(girl);
                map.put(boy,set);
            }
        }
        helper2(0,boyss,rboy,girlss,rgirl,map,girlmap,boymap);
        System.out.println(maxCount);
    }

    public static void helper2(int count,int[] boys,boolean[] rboy, int[] girls,boolean[] rgirl,HashMap<Integer,HashSet<Integer>> map,HashMap<Integer,Integer> girlmap,HashMap<Integer,Integer> boymap) {
        for (int i = 0;i<boys.length;i++){
            int boy = boymap.get(boys[i]);
            if (!rboy[boy]){
                for (int girl:map.get(boys[i])) {
                    int girlindex = girlmap.get(girl);
                    if (!rgirl[girlindex]){
                        rboy[boy] = true;
                        rgirl[girlindex] = true;
                        count ++;
                        helper2(count,boys,rboy,girls,rgirl,map,girlmap,boymap);
                        count--;
                        rboy[boy] = false;
                        rgirl[girlindex] = false;
                    }
                }
            }
        }
        maxCount = Math.max(count,maxCount);
    }


}
