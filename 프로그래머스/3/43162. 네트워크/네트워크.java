import java.util.*;
class Solution {
    boolean[] vis;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        vis = new boolean[n];
        for(int i = 0; i< computers.length;i++){
            if(vis[i])continue;
            answer++;
            bfs(computers, i);
        }
        
        return answer;
    }
    public void bfs(int[][] com, int i){
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int idx = q.poll();
            for(int j = 0; j<com[idx].length;j++){
                if(idx==j)continue;
                if(com[idx][j]==0)continue;
                if(com[idx][j]==1&&vis[j])continue;
                vis[j] = true;
                q.add(j);
            }
        }
    }
}