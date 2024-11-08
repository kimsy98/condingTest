import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length/2;

        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        if(pick>=set.size())answer = set.size();
        else answer = pick;

        return answer;
    }
}
