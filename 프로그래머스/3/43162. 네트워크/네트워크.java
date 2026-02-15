import java.util.*;
class Solution {
    boolean[] visit;
    int answer = 0;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        for(int i =0; i< n; i++){
            if(!visit[i]) bfs(i, n, computers);        
        }
        return answer;
    }
    public void bfs(int idx, int n,int[][] computers){
        visit[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(idx);
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i =0; i < n; i++){
                if(i==num)continue;
                if(computers[num][i]==0)continue;
                if(visit[i])continue;
                visit[i] = true;
                q.add(i);
            }
        }
        answer++;
    }
}