import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        if(topping.length==1)return 0;
        
        int[] lArr = new int[topping.length];
        int[] rArr = new int[topping.length];
        
        HashMap<Integer, Integer> l = new HashMap<>();
        HashMap<Integer, Integer> r = new HashMap<>();

        for(int i =0;i<topping.length; i++){
            l.put(topping[i],0);
            lArr[i]=l.size();
        }
        for(int i =topping.length-1;0<=i; i--){
            r.put(topping[i],0);
            rArr[i]=r.size();
        }
        for(int i=0; i<topping.length-1;i++){
            if(lArr[i]==rArr[i+1])answer++;
        }
        return answer;
    }
}