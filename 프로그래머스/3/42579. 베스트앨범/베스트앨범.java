import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        List<Integer> li = new ArrayList<>();
        HashMap<String, Integer> genCnt = new HashMap<>();
        HashMap<String,HashMap<Integer, Integer>> topList = new HashMap<>();
        for(int i =0; i<plays.length;i++){
            genCnt.put(genres[i], genCnt.getOrDefault(genres[i],0)+plays[i]);
            topList.put(genres[i],new HashMap<>());
        }
        System.out.println(topList.get(genres[0]));

        for(int i =0; i<plays.length;i++){
            HashMap<Integer, Integer> play = new HashMap<>();
            topList.get(genres[i]).put(i,plays[i]);
        }
        
        List<String> keySet = new ArrayList<>(genCnt.keySet());
        keySet.sort((o1,o2)-> genCnt.get(o2).compareTo(genCnt.get(o1)));
        
        for(String key : keySet){
            List<Integer> topListKeySet = new ArrayList<>(topList.get(key).keySet());
            topListKeySet.sort((o1,o2)-> topList.get(key).get(o2).compareTo(topList.get(key).get(o1)));
            li.add(topListKeySet.get(0));
            if(topListKeySet.size()>1)li.add(topListKeySet.get(1));

        }
        System.out.println(li.toString());
        

        return li.stream().mapToInt(Integer::intValue).toArray();
    }
}