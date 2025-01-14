import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String str :  operations){
            String[] oper = str.split(" ");
            String state = oper[0];
            int data = Integer.parseInt(oper[1]);
            if(state.equals("I")){
                maxQ.add(data);
                minQ.add(data);
                map.put(data,map.getOrDefault(data,0)+1);
            }else{
                if(data==1){
                    while(!maxQ.isEmpty()){
                        int check =maxQ.poll();
                        if(map.get(check)>0){
                            map.put(check,map.get(check)-1);
                            break;
                            }
                    }
                }else if(data==-1){
                    while(!minQ.isEmpty()){
                        int check =minQ.poll();
                        if(map.get(check)>0){
                            map.put(check,map.get(check)-1);
                            break;
                        }
                    }
                }
                if(minQ.isEmpty()||maxQ.isEmpty()){
                    minQ.clear();
                    maxQ.clear();
                }

            }
            
//         System.out.println("max:  "+maxQ);
//         System.out.println("min:  "+minQ);
//         System.out.println("map:  "+map);    
//         System.out.println("---------");
        
        
        }
        //minq maxq 비어있지 않고 둘이 원소값 같으면 0,0임
        //minq 비어있고 maxq비어있지 않으면 int val = maxq.poll; (val,val)
        //반대도 마찬가지
        int max=0;
        int min=0;
        while(!maxQ.isEmpty()) {
            int check = maxQ.poll();
            if(map.get(check)>0){
                max = check;
                map.put(max,map.get(check)-1); 
                break;
            }
                    
        }
        while(!minQ.isEmpty()){
            int check = minQ.poll();
            if(map.get(check)>0){
                min = check;
                break;
            }
            
        }
        if(map.get(max)==null){
         if(map.get(min)==null)answer = new int[]{0,0};
         else{
             answer[0] = min;
             answer[1] = min;
         }   
             
        }else if(map.get(min)==null) {
         if(map.get(max)==null)answer = new int[]{0,0};
         else{
             answer[0] = max;
             answer[1] = max;
         }
        }else{
             answer[0] = max;
             answer[1] = min;
        }   
             
        return answer;
    }
}