import java.util.*;
class Solution {
    static boolean[] vis;
    static List<Integer>[] wireList;
    static int answer = Integer.MAX_VALUE;
    public int solution(int n, int[][] wires) {

        wireList = new ArrayList[n+1];
        
        for(int i =0; i<=n; i++){
            wireList[i] = new ArrayList<>();
        }
        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];
            wireList[a].add(b);
            wireList[b].add(a);  
        }
        for(int i =1 ; i<=n; i++){
            for(int j =0; j<wireList[i].size(); j++){
                int copy = wireList[i].get(j);
//                 wireList[i].remove(j);
//                 wireList[copy].remove(Integer.valueOf(i));
                
                vis = new boolean[n+1];
                vis[i] = true;
                vis[copy] = true;
                int Grid1 = dfs(n, i, 1);
                
                // vis = new boolean[n+1];
                int Grid2 = dfs(n, copy, 1);
                
                System.out.println("dfs Cnt : "+Grid1 +" "+ Grid2);
                System.out.println("list "+ wireList[i]+ " // "+wireList[copy]);
                answer = Math.min(answer, Math.abs(Grid1-Grid2));
                // wireList[i].add(copy);
                // wireList[copy].add(i);
            }
        }
        return answer;
    }
    static int dfs(int n ,int idx, int cnt){

        for(int i=0; i<wireList[idx].size(); i++){
            if(vis[wireList[idx].get(i)]) continue;
            vis[wireList[idx].get(i)] = true;
            cnt = dfs(n, wireList[idx].get(i), cnt+1);
        }
        return cnt;
    }
}