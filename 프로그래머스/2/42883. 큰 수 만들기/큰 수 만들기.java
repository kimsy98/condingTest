import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = k;
        int st = 0;
        while(idx<number.length()){
            int maxNum = 0;
            for(int i =st; i<=idx;i++){
                
                if(maxNum<number.charAt(i)-'0'){
                    maxNum =number.charAt(i)-'0';
                    st = i+1;                    
                }

            }
            answer.append(maxNum);
            idx++;
        }
       
        
        return answer.toString();
    }
}