import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i =1;i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum+=j;
                if(sum==n){
                    answer++;
                    break;
                }
                if(sum>n)break;
            }
        }
        return answer;
        // int[] arr = new int[n+1];
        // Arrays.fill(arr, 1);
        // return arr[n];
    }
}