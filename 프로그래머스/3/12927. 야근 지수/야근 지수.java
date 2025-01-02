import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works){
            pq.add(work);
        }
        while(n>0&&!pq.isEmpty()){
            if(!pq.isEmpty()){
                int work = pq.poll();
                n--;
                work--;
                if(work>0)pq.add(work);
            }
        }
        while(!pq.isEmpty()){
            int val = pq.poll();
            answer +=(val*val);
        }
        return answer;
    }
}