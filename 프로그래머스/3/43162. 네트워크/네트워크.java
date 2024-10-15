import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<n;i++){
            if(visit[i])continue;
            answer++;
            visit[i] = true;
            q.add(i);
            
            while(!q.isEmpty()){
                int num = q.poll();    
                for(int j = 0;j<computers[num].length;j++){
                    if(num!=j&&computers[num][j]==1&&!visit[j]){
                        q.add(j);
                        visit[j] = true;
                    }
                }
            }
        }
        
        
        return answer;
    }
}