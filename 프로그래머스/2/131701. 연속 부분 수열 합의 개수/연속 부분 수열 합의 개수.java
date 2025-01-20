import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i =0 ;i<elements.length;i++){
            for(int j =0; j<elements.length; j++){
                int sum=0;
                for(int k =i; k<=i+j;k++){
                    sum+=elements[k%elements.length];
                }
                set.add(sum);
            }
        }
        // System.out.println(set);
        answer = set.size(); 
        return answer;
    }
}