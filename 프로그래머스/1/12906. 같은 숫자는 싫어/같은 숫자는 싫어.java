import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer;
        Deque<Integer> dq = new LinkedList<>();
        for(int num : arr){
            if(dq.isEmpty()||dq.peekLast()!=num) dq.add(num);
        }
        answer = new int[dq.size()];
        
        for(int i =0; i<answer.length; i++){
            answer[i] = dq.poll();
        }
        

        return answer;
    }
}