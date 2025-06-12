import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int qui = n;
        String str = "";
        int remain = 0;
        while(qui>1){
            qui = n/k;
            remain = n%k;
            if(remain==0) str+=" ";
            else str+= remain;
            
            n = qui;
            if(qui==1) str+=1;
        }
        StringBuffer sb = new StringBuffer(str);
        String num = sb.reverse().toString();
        StringTokenizer st = new StringTokenizer(num, " ");
        while(st.hasMoreTokens()){
            Long prime= Long.parseLong(st.nextToken());
            if(prime<=1)continue;
            int half =(int)Math.sqrt(prime);
            
            boolean isPrime  =true;
            for(int i=2; i<=half; i++){
                if(prime%i==0) {
                    isPrime = false;   
                    
                    break;
                }
            }
            if(isPrime) answer++;
            
        }
        return answer;
    }
}