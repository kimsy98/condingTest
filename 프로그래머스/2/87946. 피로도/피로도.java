class Solution {
    static boolean[] vis;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        int dunSize = dungeons.length;
        vis = new boolean[dunSize];
        dfs(k,0, dunSize,0, dungeons);
        
        return answer;
    }
    static void dfs(int k, int dep, int dunSize, int max, int[][] dungeons){
        if(dep==dunSize){
            answer = Math.max(max, answer);
            return;
        }
        for(int i =0; i<dunSize; i++){
            if(vis[i])continue;
            int minF = dungeons[i][0];
            int exF = dungeons[i][1];
            vis[i] = true;
            
            if(k>=minF){
                dfs(k-exF, dep+1, dunSize, max+1, dungeons);    
            }else{
                dfs(k, dep+1, dunSize, max,dungeons);
            }
            vis[i] = false;
            
        }
    }
}