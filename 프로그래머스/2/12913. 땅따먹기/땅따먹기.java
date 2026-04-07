import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length-1;
        for(int i = 1 ;i< land.length; i++){
            for(int j = 0 ;j< land[0].length; j++){
                int max = 0;
                for(int k=0; k<land[0].length; k++){
                    if(j==k) continue;
                    if(land[i][j]+land[i-1][k]>land[i][j]){
                        max= Math.max(max, land[i][j]+land[i-1][k]);
                    }
                }
                land[i][j] = max;
            }   
        }
        for(int i = 0; i<land[0].length; i++){
            answer = Math.max(land[n][i], answer);
        }
        return answer;
    }
}