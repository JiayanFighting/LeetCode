public class code_165 {
    public static void main(String[] args){
        String version1 = "1";
        String version2 = "1.0.1";
        int ret = compareVersion(version1,version2);
        System.out.println(ret);
    }

    public static int compareVersion(String version1, String version2){
        if (version1.length() == 0 && version2.length() == 0) return 0;
        if (version1.length() == 0) return -1;
        if (version2.length() == 0) return 1;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index = 0;
        while (index < v1.length && index < v2.length){
            if (Integer.parseInt(v1[index]) == Integer.parseInt(v2[index])){
                index++;
            }else {
                return Integer.parseInt(v1[index])> Integer.parseInt(v2[index])? 1:-1;
            }
        }
        if (index == v1.length && index == v2.length){
            return 0;
        }else if (index < v1.length){
            int sum = 0;
            while (index < v1.length){
                sum +=Integer.parseInt(v1[index]);
                index++;
            }
            if (sum == 0){
                return 0;
            }
            return 1;
        }else {
            int sum = 0;
            while (index < v2.length){
                sum +=Integer.parseInt(v2[index]);
                index++;
            }
            if (sum == 0){
                return 0;
            }
            return -1;
        }
    }
}
