import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sqrt =(int)Math.sqrt(yellow);
        for(int i =1; i<=sqrt; i++){
            if(yellow%i!=0)continue;
            if((i+2)*(yellow/i+2)-yellow!=brown)continue;
            answer[0] = yellow/i+2;
            answer[1] = i+2;
        }
        return answer;
    }
}