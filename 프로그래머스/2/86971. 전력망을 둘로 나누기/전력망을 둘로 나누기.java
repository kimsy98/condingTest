// import java.util.*;
class Solution {
    boolean[] vis;
    int[][] net;
    int N;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        N = n;
        vis = new boolean[n];
        net = new int[n][n];
        for(int[] wire : wires){
            net[wire[0]-1][wire[1]-1] = 1;
            net[wire[1]-1][wire[0]-1] = 1;
        }
        dfs(1);
        return answer;
    }
    public int dfs(int i){
        vis[i] = true;
        int child = 1;
        for(int j = 0; j<N; j++){
            if(net[i][j]==1&&!vis[j]){
                child += dfs(j);
            }
        }
        answer = Math.min(answer, Math.abs(N-2*child));
        return child;
    }
}