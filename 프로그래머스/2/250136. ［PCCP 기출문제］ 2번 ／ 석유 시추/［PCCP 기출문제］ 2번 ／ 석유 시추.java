import java.util.*;
class Solution {
    static Queue<Node> q = new LinkedList<>();
    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] vis;
    static int[] oilCnt;
    public int solution(int[][] land) {
        int answer = 0;
        int dep = land.length;
        int w = land[0].length;
        vis = new boolean[dep][w];
        oilCnt = new int[w];
        for(int i =0; i<w;i++){
            for(int j =0; j<dep; j++){
                if(land[j][i]==1&&!vis[j][i]){
                    q.add(new Node(j,i));
                    vis[j][i] = true;
                    bfs(land);
                }
                // q.clear();
            }
            // vis = new boolean[dep][w];
        }
        Arrays.sort(oilCnt);
        return oilCnt[w-1];
    }
    static void bfs(int[][] land){
        int cnt =0;
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()){
            Node node = q.poll();
            cnt++;
            int x = node.x;
            int y = node.y;
            set.add(y);
            for(int i =0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||nx>=land.length||ny<0||ny>=land[0].length)continue;
                if(vis[nx][ny]||land[nx][ny]==0)continue;
                vis[nx][ny] = true;
                q.add(new Node(nx, ny));
                
            }
        }
        // for(Node no : set){
        //     System.out.println(no.x+ ": :"+no.y); 
        // }
        // System.out.println("////////// cnt: "+ cnt);
        for(Integer s : set){
            oilCnt[s] += cnt;            
        }
    }
}