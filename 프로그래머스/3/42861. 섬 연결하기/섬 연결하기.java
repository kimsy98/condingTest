import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        List<int[]>[] arr = new ArrayList[n];
        boolean[] visit = new boolean[n];
        for(int i =0; i<n;i++){
            arr[i] = new ArrayList<>();
        }
        for(int[] cost : costs){
            arr[cost[0]].add(new int[]{cost[1],cost[2]});
            arr[cost[1]].add(new int[]{cost[0],cost[2]});   
        }
        int cnt=0;
        
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()&&cnt<n){
            int[] cost = pq.poll();
            if(visit[cost[0]])continue;
            visit[cost[0]] = true;
            answer+=cost[1];
            cnt++;
            for(int[] next : arr[cost[0]]){
                if(!visit[next[0]])pq.add(new int[]{next[0], next[1]});
            }
            
        }
        return answer;
    }
}