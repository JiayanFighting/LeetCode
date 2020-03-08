import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args){
        HashMap<String,String> map = new HashMap<>();
        map.put("k1","v1");
        map.put("k2","v2");
        map.put("k4","v4");
        map.put("k3","v3");
        map.put("k6","v6");
        map.put("k5","v5");
        ergodicHashmap(map);
    }

    public static void ergodicHashmap(HashMap<String,String> map){
        //第一种：普通使用，二次取值(性能差)
        for(String key:map.keySet()){
            System.out.println("Key: "+key+" Value: "+map.get(key));
        }

        //第二种(性能比第一种好，一次取值)
        Iterator map1it=map.entrySet().iterator();
        while(map1it.hasNext()) {
            Map.Entry<String, String> entry=(Map.Entry<String, String>) map1it.next();
            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        for(Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
        }

        // 第四种
        for(String v:map.values()) {
            System.out.println("The value is "+v);
        }
    }
}
