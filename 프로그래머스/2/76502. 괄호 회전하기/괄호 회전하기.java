import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        boolean cor  = true;
        for(int i= 0; i<s.length(); i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    cor = false;
                    break;
                }else{
                    char st = stack.pop();
                    char compare = s.charAt(i);
                    if(compare==')'&&st=='(')continue;
                    if(compare=='}'&&st=='{')continue;
                    if(compare==']'&&st=='[')continue;
                    else{
                        cor = false;
                        break;
                    }
                }
            }
        }
        if(cor&&stack.isEmpty())answer++;
        cor = true;
        
        for(int i = 1; i< s.length(); i++){
            String f = s.substring(0,1);
            String b = s.substring(1);
            s = b+f;
            // System.out.println(s);
            
            for(int j= 0; j<s.length(); j++){
                if(s.charAt(j)=='('||s.charAt(j)=='{'||s.charAt(j)=='['){
                    stack.push(s.charAt(j));
                }else{
                    if(stack.isEmpty()){
                        cor = false;
                        break;
                    }else{
                        char st = stack.pop();
                        char compare = s.charAt(j);
                        if(compare==')'&&st=='(')continue;
                        if(compare=='}'&&st=='{')continue;
                        if(compare==']'&&st=='[')continue;
                        else{
                            cor = false;
                            break;
                        }
                    }
                }
            }
            if(cor&&stack.isEmpty())answer++;
            cor = true;

        }
        return answer;
    }
}