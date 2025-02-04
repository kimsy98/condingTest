import java.util.*;
class Solution {
    public int[] solution(String s) {
                // String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        // System.out.println(Arrays.toString(arr));
        s = s.substring(2,s.length()-2).replace("},{", "/");
        
        String[] sArr = s.split("/");
        
        Arrays.sort(sArr, Comparator.comparingInt(String :: length));
        List<Integer> li = new ArrayList<>();
        for(String str : sArr){
            String[] find = str.split(",");
            for(int i=0; i<find.length; i++){
                int num = Integer.parseInt(find[i]);
                if(!li.contains(num)){
                    li.add(num);
                }
            }
        }
        return li.stream().mapToInt(Integer::intValue).toArray();
    }
}