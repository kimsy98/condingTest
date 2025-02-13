import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int tc =0; tc<commands.length;tc++){
            int i = commands[tc][0]-1;
            int j = commands[tc][1]-1;
            int k = commands[tc][2]-1;
            int size = j-i+1;
            
            int[] arr = new int[size];
            for(int st =0;st<size;st++){
                arr[st] = array[st+i];
            }
            Arrays.sort(arr);
            answer[tc] = arr[k];
        }
        return answer;
    }
}