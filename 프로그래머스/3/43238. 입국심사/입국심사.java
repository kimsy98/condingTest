import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long left = 0;
        long right = (long)times[times.length-1]*n;
        
        while(left<=right){
            long mid = (left+ right)/2;
            if(getTimeCount(times, mid)>=n){
                right = mid -1;
                answer = mid;
            }else{
                left = mid+1;
            }
        }
        
        return answer;
    }
    public long getTimeCount(int[] times, long mid){
        long timeCnt =0;
        for(int i = 0 ; i <times.length; i++){
            timeCnt += mid/times[i];
        }
        return timeCnt;
    }
}