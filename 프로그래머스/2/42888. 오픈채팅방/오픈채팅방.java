import java.util.*;
import java.io.*;
class Solution {
    public String[] solution(String[] records) throws IOException {
        List<String> answer = new ArrayList<>();
        StringTokenizer st;
        HashMap<String, String> map = new HashMap<>();
        int cnt =0;
        for(String record : records){
            st = new StringTokenizer(record);
            String state = st.nextToken();
            String userId = st.nextToken();
            String nickName;
            if(st.hasMoreTokens()){
                nickName = st.nextToken();
                map.put(userId,nickName);
            }     
        }
        for(String record : records){
            st = new StringTokenizer(record);
            String state = st.nextToken();
            String userId = st.nextToken();
            String nickName = map.get(userId);
            if(state.equals("Enter")){
                answer.add(nickName+"님이 들어왔습니다.");
            }else if(state.equals("Leave")){
                answer.add(nickName+"님이 나갔습니다.");
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}