import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        List<Integer> li = new ArrayList<>();
        int notReachIdx = 1;
        int reachIdx = 0;
        int gap = 0;
        for(int s : stations){
            //reachIdx == station 전달 범위 idx 작은 쪽
            reachIdx = s-w;
            
            gap = reachIdx - notReachIdx;
            answer += countMethod(gap, w);
            //notReachIdx == station 전달 범위 idx 큰 쪽+1
            notReachIdx = Math.max(notReachIdx,s+w+1);
        }
        if(notReachIdx<=n){
            gap = n+1-notReachIdx;
            answer += countMethod(gap, w);
        }
        

        return answer;
    }
    public int countMethod(int gap, int w){
        int count = 0;
        if(gap<0) return 0;
        if(gap!=0&&gap<=2*w+1)count++;
        else{
            count+= gap/(2*w+1);
            if(gap%(2*w+1)!=0) count++;
        }
        return count;
    }
}