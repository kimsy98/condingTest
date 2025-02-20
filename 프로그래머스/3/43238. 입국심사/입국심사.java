import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long r = times[times.length-1]*(long)n;
        long l = 0;
        
        while(l<=r){
            long mid = (l+r)/2;
            long total = 0;
            for(int time : times) total+=mid/time;
            if(total<n){
                l = mid+1;
            }else{
                r =mid-1;
                answer = mid;
            }
            
        }
        return answer;
    }
}