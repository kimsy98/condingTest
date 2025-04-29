import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.add(scov);
        }
        Integer min = pq.peek().intValue();
       
        while(pq.size() > 1 && pq.peek() < K){

                answer++;
                int num = pq.poll()+(pq.poll()*2);
                pq.add(num);            
        }
        if(pq.size() <= 1 && pq.peek() < K)answer = -1;

        return answer;
    }
}