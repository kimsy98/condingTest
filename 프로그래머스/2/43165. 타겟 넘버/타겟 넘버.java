class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0, numbers.length);
        return answer;
    }
    static void dfs(int[] numbers, int num, int target, int dep,int size){
        if(dep==size){
            if(num==target){
                answer++;
            }
            return;
        }  
        dfs(numbers, num-numbers[dep], target, dep+1, size);
        dfs(numbers, num+numbers[dep], target, dep+1, size); 
    }
}