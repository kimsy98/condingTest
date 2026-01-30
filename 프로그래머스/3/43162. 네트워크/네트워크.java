import java.util.*;
import java.io.*;
class Solution {
    boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i = 0; i<n;i++){
            if(visit[i])continue;
            visit[i] = true;
            dfs(i,computers,0, n);
            answer++;
        }

        return answer;
    }
    public void dfs(int st , int[][] computers, int dep, int n){
        // if(dep==n)break;
        for(int i=0; i<n;i++){
            if(st==i||computers[st][i]==0)continue;
            if(visit[i])continue;
            visit[i] = true;
            dfs(i, computers, dep, n);
        }
    }
}