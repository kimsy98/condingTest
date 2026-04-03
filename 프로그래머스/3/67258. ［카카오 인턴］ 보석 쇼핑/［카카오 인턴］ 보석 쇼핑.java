import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for(String gem : gems){
            if(map.get(gem)==null){
                map.put(gem, map.getOrDefault(gem, idx));            
                idx++;
            }
        }
        // for(String key : map.keySet()){
        // System.out.println(map.get(key));
        // }
        
        int lIdx = 0;
        int rIdx = map.size()-1;
        int minL = gems.length;
        Map<String, Integer> cntMap =new HashMap<>();
        for(int i = 0; i<=rIdx;i++){
            cntMap.put(gems[i], cntMap.getOrDefault(gems[i], 0)+1);
        }

        while(lIdx<=rIdx){
            //아직 모든 보석 포함 못함
            if(cntMap.size()!=map.size()){
                rIdx++;
                if(rIdx>=gems.length){
                    break;
                }
                cntMap.put(gems[rIdx], cntMap.getOrDefault(gems[rIdx],0)+1);
                // System.out.println(cntMap.size()+" : "+ map.size());
            }
            //모든 보석 포함하고 이전에 구했던 최소 길이보다 작은경우
            else if(cntMap.size()==map.size()){
                // System.out.println(rIdx + "idx" + lIdx + " " + minL);
                
                if(minL>rIdx-lIdx){
                    //answer 배열 비교해서 시작 번호 작으면 넣기
                    answer = new int[] {lIdx+1, rIdx+1};
                    minL = rIdx-lIdx;
                    
                    // System.out.println(answer[0] + " " + answer[1]);
                }
                
                if(cntMap.get(gems[lIdx])==1){
                    cntMap.remove(gems[lIdx]);
                }else{
                    cntMap.put(gems[lIdx], cntMap.get(gems[lIdx])-1);
                }
                lIdx++;
                
                if(lIdx>=gems.length)break;
                
            }
            //그외 경우 즉, 
//             else{
                
//             }
            
        }
        return answer;
    }
}