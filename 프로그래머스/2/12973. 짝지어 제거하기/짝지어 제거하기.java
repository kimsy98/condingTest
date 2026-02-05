import java.util.*;
class Solution
{
    public int solution(String s)
    {
        if(s.length()%2==1) return 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        stack.addLast(s.charAt(0));
        for(int i =1; i<s.length(); i++){
            if(!stack.isEmpty()&&s.charAt(i)==stack.peekLast()) stack.pollLast();
            else stack.addLast(s.charAt(i));
        }
        return stack.isEmpty() ? 1 : 0;
    }
}