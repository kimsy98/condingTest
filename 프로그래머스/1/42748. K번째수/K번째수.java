import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int i = 0 ; i<answer.length; i++){
            int st  = commands[i][0];
            int end = commands[i][1];
            int step = commands[i][2];
            
            int[] arr = new int[end-st+1];
            int cnt = 0;
            for(int j =st-1; j<=end-1; j++){
                arr[cnt++] = array[j];
            }
            
            Arrays.sort(arr);
            answer[i] = arr[step-1];
            
        }
        
        
        return answer;
    }
}