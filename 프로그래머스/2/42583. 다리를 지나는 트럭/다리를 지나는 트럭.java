import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> q = new LinkedList<>();
        int[] truckTime = new int[truck_weights.length];
        q.add(truck_weights[0]);
        int idx = 0;
        int nowBriW = truck_weights[0];
        truckTime[0]=1;
        int firstIdx=0;
        while(!q.isEmpty()){
            //1.시간 증가
            answer++;
            
            //2.다리위에 있는 트럭 이동
            for(int i =0; i<=idx;i++){
                if(truckTime[i]>0){
                    truckTime[i]+=1;
                }
            }
            //2-1. 다리를 지난 트럭 체크
            if(firstIdx<truck_weights.length&&truckTime[firstIdx]>bridge_length){
                int minus =q.poll();
                nowBriW-=minus;
                firstIdx++;
            }
            
            //3. 현재 트럭이 다리 진입로에 없고 다리 하중을 초과하지 않는다면 
            //트럭 한 대 다리에 올리기
            if(truckTime[idx]>1&&idx<truck_weights.length-1){
                if(nowBriW+truck_weights[idx+1]<=weight){
                    idx++;
                    q.add(truck_weights[idx]);
                    nowBriW+=truck_weights[idx];
                    truckTime[idx]++;   
                }
                
            }
            
        }
        return answer;
    }
}