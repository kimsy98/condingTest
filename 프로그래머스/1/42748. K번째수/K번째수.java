import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int tc = commands.length;
        int[] answer = new int[tc];
        for(int i =0; i<tc ; i++){
            int sIdx = commands[i][0]-1;
            int eIdx = commands[i][1]-1;
            int idx = commands[i][2]-1;
            // int[] copyArr = new int[eIdx-sIdx];
            int[] copyArr = Arrays.copyOfRange(array, sIdx,eIdx+1);
            
            Arrays.sort(copyArr);
            answer[i] = copyArr[idx];
        }
        
        
        return answer;
    }
}