import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i =0; i<want.length;i++){
            map.put(want[i], number[i]);
        }
        
        int lIdx = 0;
        int rIdx = 9;
        Map<String, Integer> discountMap = new HashMap<>();
        for(int i =0; i<10;i++){
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0)+1);
        }
//         for(String key : discountMap.keySet()){
//             System.out.println(key+" : "+discountMap.get(key));
            
//         }
        
        while(rIdx<discount.length){
            boolean check = true;
            for(String key :  discountMap.keySet()){
                
                if(!map.containsKey(key)||discountMap.get(key)!=map.get(key)){
                    check = false;
                    // break;
            // System.out.println(key+" : "+discountMap.get(key));
            // System.out.println(key+" : "+map.get(key));
                    
                }
                
            }
            System.out.println(" ");
            
            if(check)answer++;
            lIdx++;
            rIdx++;
            if(rIdx<discount.length){
                discountMap.put(discount[lIdx-1], discountMap.get(discount[lIdx-1])-1);
                discountMap.remove(discount[lIdx-1],0);
                discountMap.put(discount[rIdx], discountMap.getOrDefault(discount[rIdx],0)+1);
                // System.out.println(discountMap.get(key));
                
            }
        }
        return answer;
    }
}