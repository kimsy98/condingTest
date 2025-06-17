import java.util.*;
class Solution {
    int answer = 0;
    List<Integer>[] edg;
    public int solution(int[] info, int[][] edges) {
        edg = new List[info.length];
        for(int i =0; i<edges.length; i++){
            edg[i] = new ArrayList<>();
        }
        int remainSheep = Collections.frequency(Arrays.asList(info), 0);
        bfs(1,0,0,remainSheep, info,edges);
        return answer;
    }
    public void bfs(int sheep,int wolf,int root,int remainSheep, int[] info, int[][] edges){
        Queue<int[]> q = LinkedList<>();
        //sheep,wolf, index
        q.add(new int[] {1,0, root});
        info[0] = 0;
        while(!q.isEmpty()){
            int[] status = q.poll();
            int shCnt = status[0];
            int woCnt = status[1];
            int idx = status[2];
            for(int i =0; i<edges[idx].size(); i++){
                int nextIdx = edges[idx].get(i);
                if(nextIdx==0){
                    while(true){
                        edges[nextIdx]
                    }
                }
            }
        }
    }
}