import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int[][] dp = new int[151][151];
        int maxAlp =0;
        int maxCop =0;
        for(int[] p : problems){
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }
        for(int i =0; i<151; i++){
            Arrays.fill(dp[i], 100*150*150);        
        }
        alp = Math.min(maxAlp, alp);
        cop = Math.min(maxCop, cop);
        dp[alp][cop] = 0;
        for(int i = alp; i<=maxAlp;i++){
            for(int j = cop; j<=maxCop; j++){
                // 1. 알고 공부: 아직 만렙 아니면 오른쪽 칸 갱신
                if (i < maxAlp) {
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                }

                // 2. 코딩 공부: 아직 만렙 아니면 아래 칸 갱신
                if (j < maxCop) {
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                }
                // dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                // dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                for(int[] p : problems){
                    if(i>=p[0]&&j>=p[1]){
                        int nextAlp = Math.min(maxAlp,i+p[2]);
                        int nextCop = Math.min(maxCop,j+p[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + p[4]);
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[maxAlp][maxCop];
    }
}