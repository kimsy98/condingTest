import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> progressQ = new LinkedList <Integer>();
        Queue<Integer> speedQ = new LinkedList <Integer>();
        
        for(int i=0 ; i<progresses.length;i++){
            progressQ.add(progresses[i]);
            speedQ.add(speeds[i]);   
        }
        
        int dayDeploy =1;
        int days=0;
        int fcheck = 100-progressQ.poll();
        int fspeed = speedQ.poll();
        if(fcheck%fspeed==0){
            days=fcheck/fspeed;
        }else{
            days=fcheck/fspeed+1;
        }
        List<Integer> ansList = new ArrayList<>();
        while(!progressQ.isEmpty()){
            
            int check = 100-progressQ.poll();
            int speed = speedQ.poll();
            //전 작업과 같이 배포 가능
            if(check<=days*speed){
                dayDeploy++;
            }//배포일 달라짐
            else{
                if(check%speed==0){
                    days=check/speed;
                }else{
                    days=check/speed+1;
                }
                ansList.add(dayDeploy);
                dayDeploy = 1;
            }
        }
        ansList.add(dayDeploy);
        
        //int 타입(Primitive type) List->Array로 변환
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}