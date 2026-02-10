import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        String[] numberString = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf).toArray(String[]::new);
        
        Arrays.sort(numberString, (o1,o2)-> (o2+o1).compareTo(o1+o2));
        
        for(String num : numberString){
            answer.append(num);
        }
        if(answer.charAt(0)=='0')return "0";
        return answer.toString();
    }
}