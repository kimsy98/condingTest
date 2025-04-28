import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.add(arr[0]);
        for(int n : arr){
            if(dq.peekLast()==n)continue;
            else dq.add(n);
        }
    
        return dq.stream().mapToInt(Integer::intValue).toArray();
    }
}