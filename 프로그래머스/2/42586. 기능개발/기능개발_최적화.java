import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList <Integer>();
        
        for(int i=0 ; i<progresses.length;i++){
            if((100-progresses[i])%speeds[i]==0){
                q.add((100-progresses[i])/speeds[i]);
            }
            else{
                q.add((100-progresses[i])/speeds[i]+1);  
            }
        }
        
        
        int dayDeploy =1;
        int days=q.poll();
       
        List<Integer> ansList = new ArrayList<>();
        while(!q.isEmpty()){
            if(days>=q.peek()){
                dayDeploy++;
                q.poll();
            }else{
                days = q.poll();
                ansList.add(dayDeploy);
                dayDeploy=1;
            }
        }
        ansList.add(dayDeploy);
        
        //int 타입(Primitive type) List->Array로 변환
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}
