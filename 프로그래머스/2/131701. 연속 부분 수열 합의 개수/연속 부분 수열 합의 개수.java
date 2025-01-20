import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];
        
        for(int size =1 ;size<=elements.length;size++){
            for(int j =0; j<elements.length; j++){
                dp[j]+=elements[(size+j-1)%elements.length];
                set.add(dp[j]);
            }
        }
        // System.out.println(set);
        answer = set.size(); 
        return answer;
    }
}