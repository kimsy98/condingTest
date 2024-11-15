import java.util.*;
 
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> totalCnt = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music= new HashMap<>();
        
        for(int i =0 ; i<plays.length; i++){
            totalCnt.put(genres[i], totalCnt.getOrDefault(genres[i], 0)+plays[i]);
            
            if(!music.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i,plays[i]);
                music.put(genres[i], map);
            }else music.get(genres[i]).put(i, plays[i]);
            
        }
        
        List<String> keySet = new ArrayList(totalCnt.keySet());
        Collections.sort(keySet, (n1, n2)-> totalCnt.get(n2)-totalCnt.get(n1));
        
        for(String key : keySet){
            List<Integer> genreKey = new ArrayList(music.get(key).keySet());
            Collections.sort(genreKey, (n1, n2)-> music.get(key).get(n2)-music.get(key).get(n1));
            
            answer.add(genreKey.get(0));
            if(genreKey.size()>1) answer.add(genreKey.get(1));
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
        
        
}