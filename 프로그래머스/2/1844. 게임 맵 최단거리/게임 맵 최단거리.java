import java.util.*;

class Solution {
     class Node{
        int x,y;
        int cnt;
        public Node(int x,int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[] nx = {0,1,0,-1};
    static int[] ny = {1,0,-1,0};
    
    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    public int bfs(int[][] map){
        Queue<Node>q = new LinkedList<>();
        boolean[][] vis = new boolean[map.length][map[0].length];
        vis[0][0] = true;
        
        q.add(new Node(0,0,1));

        while(!q.isEmpty()){
            Node node = q.poll();
            
            int x = node.x;
            int y = node.y;
            int cnt = node.cnt;
            
            for(int i=0;i<4;i++){
                int nr =x+nx[i];
                int nc =y+ny[i];
                if(nr<0||nr>=map.length||nc<0||nc>=map[0].length)continue;
                if(vis[nr][nc]||map[nr][nc]==0)continue;
                vis[nr][nc] = true;
                map[nr][nc] = cnt+1;
                q.add(new Node(nr,nc,cnt+1));
            }
        }
        if(vis[map.length-1][map[0].length-1])return map[map.length-1][map[0].length-1];
        return -1;
    }
}