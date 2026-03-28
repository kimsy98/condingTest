import java.util.*;
class Solution {
    static final int FINAL_TIME = 60*23+59;
    
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> totalMap = new HashMap<>();

        for(String record :records){
            st = new StringTokenizer(record);
            String[] arr = st.nextToken().split(":");
            int time = Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
            int carNumber = Integer.parseInt(st.nextToken());
            String state = st.nextToken();
            // System.out.println(time + " / " + carNumber + " / " + state );
            if(state.equals("IN")){
                map.put(carNumber, time);
            }else{
                totalMap.put(carNumber, totalMap.getOrDefault(carNumber,0)+time-map.get(carNumber));
                map.remove(carNumber);
            }
        }
        for(int key : map.keySet()){
            totalMap.put(key, totalMap.getOrDefault(key,0)+FINAL_TIME-map.get(key));
        }
        
        List<Integer> keySet = new ArrayList(totalMap.keySet());
        Collections.sort(keySet);
        for(int key : keySet){
            answer.add(calcul(totalMap.get(key), fees));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    
    
    
    public int calcul(int totalTime, int[] fees){
        int basicHour = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        int result = basicFee+(int)Math.ceil(((float)totalTime-(float)basicHour)/unitTime) *unitFee;
        if(result<basicFee) result = basicFee;
        return result;
    }
}