import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String loopResult = s;
        int loopCount = 0;
        int zeros = 0;
        while (!loopResult.equals("1")){
            StringTokenizer st = new StringTokenizer(loopResult, "0", true);
            loopResult = "";
            while (st.hasMoreTokens()){
                String token = st.nextToken();
                if (token.charAt(0) == '1') {
                    loopResult = loopResult + token;
                }
                else { //token.charAt(0) == '0'
                    zeros+=token.length();
                }
            }//while
            int length = loopResult.length();
            String buff = "";
            do {
                buff = length%2 + buff;
                length /= 2;
            } while(length != 0);

            loopResult = buff;
            loopCount++;
        }//while

        answer = new int[] {loopCount, zeros};
        return answer;
    }
}