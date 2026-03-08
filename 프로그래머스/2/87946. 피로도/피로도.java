import java.util.*;
class Solution {
    boolean[] vis;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int n = dungeons.length;
        for(int i =0 ; i<n; i++){
            vis = new boolean[n];
            vis[i] = true;
            dfs(dungeons, i, 0, n, k, 0);
        }
        answer = max;
        return answer;
    }
    public void dfs(int[][] dung, int idx, int dep, int n, int k, int ans){
        if(dung[idx][0]<=k){
            k-=dung[idx][1];
            ans++;  
        }
        
        if(dep==n-1){
            max = Math.max(max, ans);
            return;
        }

        
        for(int i = 0; i<n; i++){
            if(vis[i])continue;
            vis[i] = true;
            dfs(dung, i, dep +1, n, k, ans);
            vis[i] = false;            
            
        }
    }
}