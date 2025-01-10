import java.util.*;

class Solution {
    static int[][] map;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n+1][m+1];
        
        for(int[] puddle : puddles){
            int x = puddle[1];
            int y = puddle[0];
            map[x][y] = -1;
        }
        map[1][1]=1;
        for(int i=1; i<=n;i++){
            for(int j=1; j<=m;j++){
                if(i==1&&j==1)continue;
                if(map[i][j]==-1)continue;
                int checkup = (map[i][j-1]==-1) ? 0 : map[i][j-1];
                int checkleft = (map[i-1][j]==-1) ? 0 : map[i-1][j];
                map[i][j] = (checkup+checkleft)%1000000007;
            }
        }        
        answer = map[n][m];
        return answer;
    }
    
    
    
}