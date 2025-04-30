import java.util.*;
class Solution {
    static boolean[] vis;
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        List<Integer>[] li = new ArrayList[n];
        vis = new boolean[n];
        for(int i =0; i<li.length; i++){
            li[i] = new ArrayList<>();
        }
        
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(i==j) continue;
                if(computers[i][j]==1)li[i].add(j);
            }
        }
        
        for(int i =0; i<n; i++){
            if(!vis[i]){
                vis[i] = true;
                dfs(li, i);
                answer++;
            }
        }

        return answer;
    }
    static void dfs(List<Integer>[] li, int idx){
        for(int i =0; i<li[idx].size(); i++){
            if(vis[li[idx].get(i)])continue;
            vis[li[idx].get(i)] = true;
            dfs(li, li[idx].get(i));
        }
    }
}