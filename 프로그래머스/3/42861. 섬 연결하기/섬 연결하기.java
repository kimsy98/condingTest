import java.util.*;
class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for(int i = 0 ; i<n; i++){
            parent[i] = i;
        }
        Arrays.sort(costs, (a,b)-> a[2]-b[2]);
        
        for(int[] cost : costs){
            int from = cost[0];
            int to = cost[1];
            int co = cost[2];
            
            if(find(from)!=find(to)){
                union(from, to);
                answer+=co;
                
            }
        }
        return answer;
    }
    public int find(int x){
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY) parent[rootY] = rootX;
    }
}