import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b)-> a[1]-b[1]);
        
        answer++;
        int carCnt = 1;
        
        int lastCctvIdx = routes[0][1];
        for(int i = 1; i< routes.length; i++){
            // System.out.println(Arrays.toString(routes[i]));
            if(routes[i][0]<=lastCctvIdx){
                carCnt++;        
            }else{
                lastCctvIdx = routes[i][1];
                answer++;
            }
            
        }
        return answer;
    }
}