import java.util.HashMap;

public class code_13 {
    public static void main(String[] args){
        String s = "MCMXCIV";
        int result =  romanToInt(s);
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        int result = 0 ;
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        char c = 'I' , last = 'I';
        int c_num = 1,last_num = 1001;
        for (int i =0;i<s.length();i++){
            c = s.charAt(i);
            c_num = map.get(String.valueOf(c));

            if (last_num < c_num){
                result = result - last_num +  map.get(last+""+c);
            }else{
                result += c_num;
            }
            last = c;
            last_num = c_num;
        }
        return result;
    }
}
