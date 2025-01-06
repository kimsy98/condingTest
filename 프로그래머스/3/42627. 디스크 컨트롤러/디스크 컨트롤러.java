/***
정렬 기준:
    1. 작업 소요시간 짧은 순
    2. 작업 요청 시각 빠른 순
    3. 작업 번호 작은 순
***/
import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        Arrays.sort(jobs,(o1,o2)->o1[0]-o2[0]);
        
        //0 : 작업 요청 시간, 1 : 작업 소요시간
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        
        int nowTime = jobs[0][0];
        int idx =0;
        while(idx<n||!pq.isEmpty()){
            while(idx<n&&nowTime>=jobs[idx][0]){
                pq.add(jobs[idx++]);
            }
            if(pq.isEmpty()){
                nowTime=jobs[idx][0];
                pq.add(jobs[idx++]);
            }

            int [] job = pq.poll();
            int s = job[0];
            int i = job[1];

            nowTime+=i;
            answer+=nowTime-s;


        }


        return answer/n;
    }
}