import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code_49 {

    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = groupAnagrams(strs);
        for (List<String> integers : ret) {
            for (String integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        if (strs.length == 0){
            return ret;
        }
        HashMap<String,List<String>> map = new HashMap<>();
        // 将每个字符串转换为一串标识各个字母个数的字符串
        for (String s : strs) {
            int[] record = new int[26];
            for (int j = 0; j < s.length(); j++) {
                record[s.charAt(j) - 97]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(record[j]);
                sb.append("#");//0 2 4 6 8
            }
            String news = sb.toString();
            if (map.containsKey(news)) {
                List<String> list = map.get(news);
                list.add(s);
                map.put(news, new ArrayList<>(list));
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(news, list);
            }
        }

        ret.addAll(map.values());
        return ret;
    }
}
