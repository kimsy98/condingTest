import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.add(scov);
        }
        int min = pq.peek().intValue();
        // System.out.println(min);
        while(min<K){
            if(pq.size()>=2){
                answer++;
                int num = pq.poll()+(pq.poll()*2);
                pq.add(num);
                min = pq.peek();
            }else{
                return -1;               
            }
        }
        
        return answer;
    }
}