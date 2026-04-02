import java.util.*;
class Node {
    int x,y;
    int cost,dir;
    Node(int x, int y, int cost , int dir){
        this.x = x;
        this.y =y;
        this.cost = cost;
        this.dir = dir;
    }
}
class Solution {
    // 우 하 좌 상
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][][] dist = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        } 
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost); 
        if(board[0][1]==0){
            dist[0][1][1] = 100;
            pq.add(new Node(0, 1, 100, 0));
        }
        if(board[1][0]==0){
            dist[1][0][0] = 100;
            pq.add(new Node(1, 0, 100, 1));
        }
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(cur.cost > dist[cur.x][cur.y][cur.dir]) continue;
            if(cur.x == n-1 && cur.y ==n-1){
                answer = Math.min(answer, cur.cost);
                continue;
            }
            for(int i = 0 ; i<4 ; i++){
                int nx = dx[i]+ cur.x;
                int ny = dy[i]+ cur.y;
                if(ny < 0||nx<0||ny>= n||nx>= n||board[nx][ny]==1)continue;
                int nextCost = cur.cost + (cur.dir==i? 100 : 600);
                if(nextCost<= dist[nx][ny][i]){
                    dist[nx][ny][i] = nextCost;
                    pq.add(new Node(nx,ny, nextCost, i));
                }
            }
        }
        
        return answer;
        
    }
}