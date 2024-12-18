import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, HashMap<String, Integer>> person = new HashMap<>();
        HashMap<String, Integer> giftScore = new HashMap<>();
        
        for(String friend : friends){
            person.put(friend, new HashMap<>());
            giftScore.put(friend,0);
        }

        for(String gift : gifts){
            StringTokenizer st = new StringTokenizer(gift);
            String giv = st.nextToken();
            String rec = st.nextToken();
            person.get(giv).put(rec, person.get(giv).getOrDefault(rec, 0)+1);
            giftScore.put(giv, giftScore.getOrDefault(giv,0)+1);
            giftScore.put(rec, giftScore.getOrDefault(rec,0)-1);
            
        }
        
        
        //돌면서 선물 최대값 예측
        for(String my : person.keySet()){
            int res = 0;
            for(String you : person.keySet()){
                if(my.equals(you))continue;
                
                int myP = person.get(my).getOrDefault(you,0);
                int youP = person.get(you).getOrDefault(my,0);
                if(myP>youP){
                    res++;
                }else if(myP==youP||(myP==0&&youP==0)){
                    if(giftScore.get(my)>giftScore.get(you)){
                        res++;
                    }
                }
            }
            answer = Math.max(res, answer);
        }
        
        return answer;
    }
}