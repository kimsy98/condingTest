import java.util.*;
class Solution {
    /***
    1. jobs[i][1] (소요시간) 짧은 순, jobs[i][0](요청 시각) 빠른 순, i (작업 번호) 작은 순
    
    ***/
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]){
                if(a[0]==b[0]){
                    return a[2]-b[2];
                }else{
                    return a[0]-b[0];
                }
            }else{
                return a[1]-b[1];
            }
        });
        
        int nowTime = 0;
        int idx = 0;
        while(idx<n||!pq.isEmpty()){
            while(idx<n&&jobs[idx][0]<=nowTime){
                pq.add(new int []{jobs[idx][0], jobs[idx][1], idx});
                idx++;
            }
            if(pq.isEmpty()){
                nowTime = jobs[idx][0];
                // pq.add(new int[] {jobs[idx][0], jobs[idx][1], idx});
                // idx++;
            }
            else{
                int[] now = pq.poll();
                nowTime += now[1];
                answer += nowTime-now[0];          
            }

        }
        return answer/n;
    }
}