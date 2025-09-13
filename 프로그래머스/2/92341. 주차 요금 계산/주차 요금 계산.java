import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        Map<Integer, Integer> totalRecords = new HashMap<>();
        Map<Integer, Integer> record = new HashMap<>();
        
        for(String reco : records){
            String[] data = reco.split(" ");
            String[] time = data[0].split(":");
            
            int totalTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            int carNumber = Integer.parseInt(data[1]);
            String type = data[2];
            
            if(type.equals("IN")){
                record.put(carNumber, totalTime);
            }else{
                int inTime = record.get(carNumber);
                record.remove(carNumber);
                totalRecords.put(carNumber, totalRecords.getOrDefault(carNumber, 0) + totalTime- inTime);
            }
        }
        record.forEach((key, value)->{
            int totalTime = 23*60 + 59;
            int carNumber = key;
            int inTime = value;
            totalRecords.put(carNumber, totalRecords.getOrDefault(carNumber, 0) + totalTime- inTime);
        });
                
        List<Integer> keySet = new ArrayList(totalRecords.keySet());
        Collections.sort(keySet);
        answer = new int[keySet.size()];
        int count = 0;
        for(Integer key : keySet){
            int time = totalRecords.get(key);
            if(time > fees[0]){
                answer[count] = fees[1] + ((int) Math.ceil((double)(time - fees[0]) / fees[2])) * fees[3];            
            }else{
                answer[count] = fees[1];
            }
            // System.out.println(time);
            count++;
        }
        
        return answer;
    }
}