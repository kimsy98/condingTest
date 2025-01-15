class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for(int i =1; i<land.length;i++){
            for(int j =0; j<4;j++){
                int max = 0;
                for(int n=0;n<4;n++){
                    if(n==j)continue;
                    max = (max>land[i][j]+land[i-1][n]) ? max :land[i][j]+land[i-1][n];
                }
                land[i][j] = max;
            }
        }
        for(int i =0; i<4; i++){
            answer = (answer< land[land.length-1][i]) ? land[land.length-1][i] : answer;
        }
        return answer;
    }
}