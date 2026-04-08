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
    //우, 하, 좌, 상
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][][] dist = new int[n][n][4];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                Arrays.fill(dist[i][j],Integer.MAX_VALUE);
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.cost-b.cost);
        if(board[0][1]!=1){
            dist[0][1][0] = 100; 
            pq.add(new Node(1,0,100, 0));            
        }
        if(board[1][0]!=1){
            dist[1][0][1] = 100; 
            pq.add(new Node(0,1,100, 1));            
        }
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.cost< dist[cur.y][cur.x][cur.dir])continue;
            if(cur.y==n-1&&cur.x==n-1){
                answer = Math.min(cur.cost, answer);
                continue;
            }
            for(int i = 0; i<4; i++){
                int nx = dx[i]+cur.x;
                int ny= dy[i]+cur.y;
                if(nx<0||nx>=n||ny<0||ny>=n||board[ny][nx]==1)continue;
                int nextCost = cur.cost+ (cur.dir==i ? 100 : 600);
                if(nextCost<= dist[ny][nx][i]){
                    dist[ny][nx][i] = nextCost;
                    pq.add(new Node(nx,ny,nextCost,i));
                }
            }
            
        }
        return answer;
    }
}