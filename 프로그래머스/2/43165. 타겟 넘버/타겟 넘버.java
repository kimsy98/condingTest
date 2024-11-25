class Solution {
    static int answer =0;
    
    public int solution(int[] numbers, int target) {
        

        dfs(numbers, target, numbers.length, 0, 0);
        
        
        return answer;
    }
    public static void dfs(int[] numbers, int target,int n, int depth, int res){
        if(depth==n){
            if(target==res) answer++;
            return;
        }
        dfs(numbers, target, n,depth+1, res+numbers[depth]);
        dfs(numbers, target, n,depth+1, res-numbers[depth]);

        
    }
}