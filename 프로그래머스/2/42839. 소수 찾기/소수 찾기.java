import java.util.*;

class Solution {
    static Set<Integer> hset = new HashSet<>();
    static boolean[] visit;
    public int solution(String numbers) {
        int answer = 0;
        visit = new boolean[numbers.length()];
        
        //int num으로 숫자 만들기(set 사용해 중복 제거)Integer.parseInt("011") => 11로 변환됨
        dfs(numbers, "",0);
        
        for(int num : hset){
           if(isPrime(num))answer++;
        }
        
        return answer;
    }
    static void dfs(String numbers, String num, int depth){
        if(depth>numbers.length()){
            return;
        }
        
        for(int i=0; i<numbers.length();i++){
            if(visit[i])continue;
            visit[i] = true;
            hset.add(Integer.parseInt(num+numbers.charAt(i)));
            dfs(numbers, num+numbers.charAt(i), depth+1);
            visit[i] = false;
            
        }
    }
    //소수면 true반환
    static boolean isPrime(int n){
        
        if(n<2)return false;
        
        for(int i =2; i<=(int)Math.sqrt(n); i++){
            if(n%i==0)return false;
        }
        return true;
    }
    
    
}