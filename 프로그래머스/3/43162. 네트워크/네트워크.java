class Solution {
    int answer = 0;
    boolean[] visit;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        for(int i = 0 ;i<n; i++){
            if(visit[i]) continue;
             visit[i] = true;
             dfs(computers, i, n, 0);
             answer++;
        }
        return answer;
    }
    public void dfs(int[][] computers, int idx, int n, int dep){
        if(dep==n)return;
        for(int i = 0; i<n; i++){
            if(i==idx) continue;
            if(computers[idx][i]==0|| visit[i])continue;
            visit[i] = true;
            dfs(computers, i, n, dep+1);
        }
        
    }
}