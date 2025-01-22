class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int maxLevel = 0;
        int left = diffs[0];
        for(int diff : diffs){
            maxLevel = (maxLevel < diff)? diff : maxLevel;
        }
        int right = maxLevel;
       
        long nowLimit = 0;
        while(left<=right){
            int nowLevel = (right + left)/2;
        
            for(int i=0; i<diffs.length; i++){
                if(diffs[i]<=nowLevel){
                    nowLimit+=times[i];
                }else{
                    nowLimit += (diffs[i]-nowLevel)*(times[i]+times[i-1])+times[i];        
                }

            }
                    //nowLevel이 더 높아야 가능한 상태
            if(nowLimit>limit){
                left = nowLevel+1;
                nowLimit =0;
            }else{//nowLevel 더 낮아도 됨
                answer = nowLevel;
                right = nowLevel-1;
                nowLimit = 0;
            }
            
        }
        return answer;
    }
}