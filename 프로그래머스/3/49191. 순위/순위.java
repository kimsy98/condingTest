class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] g = new int[n+1][n+1];
        for(int[] edge : results){
            g[edge[0]][edge[1]] = 1;
            g[edge[1]][edge[0]] = -1;
        }
        
        for(int i =1; i<=n; i++){
            for(int j =1; j<=n; j++){
                for(int k =1; k<=n; k++){
                    if(g[i][k]==1&&g[k][j]==1){
                        g[i][j] = 1;
                        g[j][i] = -1;
                    }
                    if(g[i][k]==-1&&g[k][j]==-1){
                        g[i][j] = -1;
                        g[j][i] = 1;
                    }
                }   
            }
        }
        for(int i =1; i<=n; i++){
            int cnt = 0;
            for(int j =1; j<=n; j++){
                if(g[i][j]==1||g[i][j]==-1){
                    cnt++;                    
                }
            }
            if(cnt==n-1)answer++;
        }
        return answer;
    }
}