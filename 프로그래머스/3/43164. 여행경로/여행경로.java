import java.util.*;
class Solution {
    boolean[] vis;
    boolean check;
    List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b)->a[1].compareTo(b[1]));
        vis = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs("ICN", 0,tickets, vis, path);
            System.out.println(answer+" :answer+out");
        
        return answer.stream().toArray(String[]::new);
    }
    public void dfs(String now,int dep, String[][] tickets, boolean[] vis , List<String> path){
        if(check) return;
        if(dep==tickets.length){
            answer = new ArrayList(path);
            check = true;
            return;
        }
        
        for(int i = 0; i<tickets.length; i++){
            if(vis[i]||!now.equals(tickets[i][0]))continue;
            vis[i] = true;
            path.add(tickets[i][1]);
            dfs(tickets[i][1], dep+1, tickets, vis, path);
            vis[i] = false;
            path.remove(path.size()-1);
        }
        
        
    }
}