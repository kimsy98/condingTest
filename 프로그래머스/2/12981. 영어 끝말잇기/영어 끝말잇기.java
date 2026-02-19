import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[] {0,0};
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char lastAlpha = words[0].charAt(words[0].length()-1);
        
        for(int i =1; i< words.length; i++){
            char nowAlpha = words[i].charAt(0);
            if(set.contains(words[i])||lastAlpha!=nowAlpha){//나온 단어를 말한경우 or 틀리게 말한경우                return new int[] {i % n + 1, i / n + 1};

                answer[0] = i%n+1;
                answer[1] = i/n+1;
                // System.out.println("들어옴");
                
                break;
            }else{
                set.add(words[i]);
                lastAlpha = words[i].charAt(words[i].length()-1);
            }
                // System.out.println(i +" exit :" + lastAlpha +" :: "+ nowAlpha);
            
        }
        return answer;
    }
}