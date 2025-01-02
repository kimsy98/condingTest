import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer =new int[n];
        int[] fail = {-1};
        if(s/n==0)return fail;
        int base = s/n;
        for(int i =0; i<n;i++){
            answer[i] = base; 
            s-=base;
        }
        
        while(s>0){
            for(int i=0; i<n;i++){
                if(s==0)break;
                answer[i]+=1;
                s--;
            }
        }
        Arrays.sort(answer);
        
        return answer;
    }
}