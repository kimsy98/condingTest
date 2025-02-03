import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0)return answer+=cities.length*5;

        Deque<String> dq = new LinkedList<>();
        Stack<String> st = new Stack<>();
        for(String city : cities){
            city = city.toLowerCase();
            if(!dq.contains(city)){
                if(dq.size()>=cacheSize){
                    dq.poll();    
                }
                dq.add(city);
                answer+=5;
                            // System.out.println(dq);
            }else{
                while(true){
                    String now = dq.poll();
                    if(now.equals(city)){
                        answer++;
                        dq.add(city);
                        while(!st.isEmpty()){
                            dq.offerFirst(st.pop());
                        }
                        break;
                    }
                    st.push(now);
                }
                            // System.out.println(dq);
            }

        }
        
        return answer;
    }
}