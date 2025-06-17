class Solution {
    static int answer = 0;
    public int solution(int[] info, int[][] edges) {
        boolean[] vis = new boolean[info.length];
        dfs(info, edges, 0, 0,0, vis);
        
        return answer;
    }
    public void dfs(int[] info, int[][] edges, int idx,int sheepCnt, int wolfCnt, boolean[] vis){
        vis[idx] = true;
        if(info[idx]==0){
            sheepCnt++;
            answer = Math.max(answer, sheepCnt);
        }else{
            if(sheepCnt <=wolfCnt+1){
                return;
            }
            wolfCnt++;
        }
        
        for(int i =0; i<edges.length;i++){
            int[] edge = edges[i];
            int start = edge[0];
            int end = edge[1];
            if(vis[start]&&!vis[end]){
                boolean[] visitArr = new boolean[info.length];
                for(int j =0; j< vis.length; j++){
                    visitArr[j] = vis[j];
                }
                dfs(info, edges, end, sheepCnt, wolfCnt, visitArr);
            }
            
            
        }
        
    }
}