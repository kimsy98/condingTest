import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int n = A.length;
        int aIdx = 0;
        int bIdx = 0;
        
        while(aIdx<n&&bIdx<n){
            if(A[aIdx]<B[bIdx]){
                aIdx++;
                bIdx++; 
                answer++;

            }else{
                bIdx++;                            
            }
        }
        return answer;
    }
}
