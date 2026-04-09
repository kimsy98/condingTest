import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left =1;
        int right = distance;
        Arrays.sort(rocks);
        
        while(left<=right){
            int mid = (right+left)/2;
            if(getRemoveRockCnt(rocks, distance,mid)<=n){
                answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return answer;
    }
    public int getRemoveRockCnt(int[] rocks, int end, int mid){
        int prevRock = 0;
        int removeRockCnt =0;
        for(int i =0; i<rocks.length; i++){
            if(rocks[i]-prevRock<mid){
                removeRockCnt++;
            }else{
                prevRock = rocks[i];
            }
        }
        if(end-prevRock<mid) removeRockCnt++;
        return removeRockCnt;
    }
    
}