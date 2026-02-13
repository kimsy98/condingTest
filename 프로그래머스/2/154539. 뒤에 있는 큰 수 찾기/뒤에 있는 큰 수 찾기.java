import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> st = new Stack<>();
        
        for(int i = n-1; i>=0;i--){
            while(!st.isEmpty()&&st.peek()<=numbers[i]){
                st.pop();
            }
            if(!st.isEmpty()) answer[i] = st.peek();
            st.push(numbers[i]);
        }
        return answer;
    }
}