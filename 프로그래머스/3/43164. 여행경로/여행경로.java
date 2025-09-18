import java.util.*;
class Solution {
    static boolean[] vis;
    static List<String> li = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        vis = new boolean[tickets.length];
        
        dfs(0,"ICN", "ICN", tickets);
        Collections.sort(li);
        answer = li.get(0).split(" ");
        return answer;
    }
    static void dfs(int dep, String plan, String now, String[][] tickets){
        if(dep==tickets.length){
            li.add(plan);
        }
        for(int i=0; i<vis.length;i++){
            
            if(!vis[i]&&now.equals(tickets[i][0])){
                vis[i] =true;
                
                dfs(dep+1,plan+" "+tickets[i][1], tickets[i][1], tickets);
                vis[i] = false;
            }
        }
    }
}