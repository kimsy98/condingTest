class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        if(triangle.length==1){
            answer = triangle[0][0];
            return answer;
        }
        
        for(int i  = triangle.length-1 ; i>=1; i--){
            
            for(int  j =0; j<triangle[i].length-1; j++){
                triangle[i-1][j] = Math.max(triangle[i][j]+triangle[i-1][j],triangle[i][j+1]+triangle[i-1][j]);
            }
            
        }
        answer = triangle[0][0];
        
        return answer;
    }
}