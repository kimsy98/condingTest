import java.util.*;
class Solution {
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n+1][n+1];
        
        for(int i = 0; i<wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            
            arr[from][to] = 1;
            arr[to][from] = 1;
        }
        
        for(int i = 0; i<wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            
            arr[from][to] = 0;
            arr[to][from] = 0;
            
            answer = Math.min(answer, bfs(n, from));
            
            arr[from][to] = 1;
            arr[to][from] = 1;
            
        }
        return answer;
    }
    
    static int bfs(int n, int from){
        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        vis[from] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int start = q.poll();
            
            for(int i = 1 ; i<=n; i ++){
                if(arr[start][i]==1&&!vis[i]){//노드 있고 방문 안한거면
                    vis[i] = true;
                    cnt++;
                    q.add(i);
                }
            }
        }
        
        return Math.abs((n-cnt)-cnt);
    }
}