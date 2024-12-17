class Solution {
    static boolean[][] vis;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        vis = new boolean[102][102];
        //지형 색칠
        for(int[] rect : rectangle){
            int lx = rect[0]*2;
            int ly = rect[1]*2;
            int rx = rect[2]*2;
            int ry = rect[3]*2;
            for(int i=lx;i<=rx; i++ ){
                for(int j =ly; j<=ry; j++){
                    if(i==lx||i==rx||j==ly||j==ry){
                        if(map[i][j]==2)continue;
                        map[i][j] = 1;
                    } 
                    else{
                        map[i][j] = 2;
                    }
                }
            }
        }
        //이동
        vis[characterX*2][characterY*2] = true;
        // for(int i =0; i<=50;i++){
        //     for(int j =0; j<=50; j++){
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        dfs(characterX*2,characterY*2,itemX*2,itemY*2, 0);
        
        
        return answer/2;
    }
    static void dfs(int x, int y, int ix, int iy, int cnt){
        if(x==ix && y==iy){
            vis[x][y] = false;
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            //방문했으면 통과(맵 범위는 벗어날 수가 없음)
            if(vis[nx][ny])continue;
            if(map[nx][ny]==1){
                vis[nx][ny] = true;
                dfs(nx, ny, ix, iy, cnt+1);

            }
            
        }
    }
}