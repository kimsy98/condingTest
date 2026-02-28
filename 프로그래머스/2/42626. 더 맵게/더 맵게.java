import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville){
            pq.add(scov);
        }
        if(pq.peek()>=K)return 0;
        while(pq.peek()<K&&pq.size()>1){
            answer++;
            int mix = pq.poll()+pq.poll()*2;
            pq.add(mix);
        }
        if(pq.peek()<K)return -1;
        return answer;
    }
}