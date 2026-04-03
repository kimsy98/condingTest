import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);
        
        int left = 1;
        int right = distance;

        while(left<=right){
            
            int mid = (right+left)/2;
            
            if(checkRockCnt(rocks, distance, mid)<=n){
                answer = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
            
        }
        
        
        return answer;
    }
    public int checkRockCnt(int[] rocks, int end, int mid){
        int removeRockCnt=0;
        int prevRock=0;
        for(int i =0; i< rocks.length; i++){
            if(rocks[i]-prevRock<mid){
                removeRockCnt++;
            }else{
                prevRock = rocks[i];
            }
        }
        if(end - prevRock<mid) removeRockCnt++;
        return removeRockCnt;
    }
}