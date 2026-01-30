class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int topCount = 0;
        
        for(int top : tops){
            if(top==1)topCount++;
        }
        
        int totalSize = 2*n+1+topCount;
        int[] dp = new int[totalSize];
        boolean[] prevTopCheck = new boolean[totalSize];
        
        int countTop = 0;
        for(int i =0; i< n; i++){
            if(tops[i]==1){
                countTop++;
                prevTopCheck[2*(i+1)+countTop] = true;  
            } 
        }
        
        dp[0] = 1;
        dp[1] = 2;
        for(int i =2; i<totalSize; i++){
            if(prevTopCheck[i]) dp[i] = (dp[i-1]+dp[i-3])%10007;
            else dp[i] = (dp[i-1]+dp[i-2])%10007;
        }
        answer = dp[totalSize-1];
        return answer;
    }
}