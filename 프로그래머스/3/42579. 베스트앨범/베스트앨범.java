import java.util.*;
 
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        HashMap<String, Integer> topList = new HashMap<>();
        for(String genre : genres){
            map.put(genre, new HashMap<>());
        }
        
        for(int i =0; i<plays.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            map.get(genre).put(i, play);
            // System.out.println(map.get(genre));
        }
        for(String gen : map.keySet()){
            int totalPlay = 0;
            for(int i : map.get(gen).keySet()){
                totalPlay+= map.get(gen).get(i);
            }
            topList.put(gen, totalPlay);
        }
        List<String> keySet = new ArrayList<>(topList.keySet());
        keySet.sort(((o1,o2)->topList.get(o2)-topList.get(o1)));

        for(String gen :keySet){
            List<Integer> playKeySet = new ArrayList<>(map.get(gen).keySet());
            playKeySet.sort(((o1,o2)->map.get(gen).get(o2)-map.get(gen).get(o1)));
            answer.add(playKeySet.get(0));
            if(playKeySet.size()>1) answer.add(playKeySet.get(1));
        } 
        
        return  answer.stream().mapToInt(i->i).toArray();
    }
        
        
}