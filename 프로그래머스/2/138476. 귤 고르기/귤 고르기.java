import java.util.*;
class Solution {
    public int solution(int k, int[] tangerines) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int tangerine : tangerines){
            map.put(tangerine, map.getOrDefault(tangerine, 0)+1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        Collections.sort(keySet,(o1,o2)-> map.get(o2).compareTo(map.get(o1)));
        int nowTangerine =0;
        for(int key : keySet){
            if(nowTangerine<k){
                nowTangerine+= map.get(key);
                answer++;
            }else break;
        }
        
        
        return answer;
    }
}