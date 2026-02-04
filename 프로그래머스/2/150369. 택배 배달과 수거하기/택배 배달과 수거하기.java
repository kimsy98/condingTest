import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int idx = deliveries.length;
        Stack<Integer> delStack = new Stack<>();
        Stack<Integer> pickStack = new Stack<>();
        boolean zeroCheck =false;
        for(int i = 0; i<n; i++){
            if(deliveries[i]>0||pickups[i]>0)zeroCheck = true;
            delStack.push(deliveries[i]);
            pickStack.push(pickups[i]);
        }
        
        int capa = cap;
        int delIdx = idx;
        int pickIdx = idx;
        
        if(!zeroCheck) return answer;
        while(idx>0){
            capa=cap;
            while(true){
                if(delStack.isEmpty()){
                    delIdx = 0;
                    break;
                }
                //집에 전체 배달 가능
                if(capa - delStack.peek() >=0){
                    capa-= delStack.pop();
            // System.out.println("capa : "+ capa);
                    
                }else{
                    //일부만 배달 가능
                    if(capa>0){
                        int delivery = delStack.pop();
                        delivery -= capa;
                        delStack.push(delivery);
                        capa = 0;
                    }//배달 더 못하는 상태 회수해야함
                    else{
                        delIdx = delStack.size();
                        break;
                    }
                }
            }
            capa= cap;
            //pickup
            while(true){
                if(pickStack.isEmpty()){
                    pickIdx = 0;
                    break;
                }
                //집에 전체 배달 가능
                if(capa - pickStack.peek() >=0){
                    capa-= pickStack.pop();
                }else{
                    //일부만 배달 가능
                    if(capa>0){
                        int pick = pickStack.pop();
                        pick -= capa;
                        pickStack.push(pick);
                        capa = 0;
                    }//배달 더 못하는 상태 회수해야함
                    else{
                        pickIdx = pickStack.size();
                        break;
                    }
                }
            }
            answer += (idx)*2;
            idx = Math.max(delIdx, pickIdx);
            
            // System.out.println("answer : " + answer+" idx : "+ idx);
            
        }
        return answer;
    }
}