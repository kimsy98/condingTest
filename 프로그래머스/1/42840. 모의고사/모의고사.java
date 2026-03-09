import java.util.*;
class Solution {
    int[] supo1 = {1,2,3,4,5};
    int[] supo2 = {2,1,2,3,2,4,2,5};
    int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        int supo1Score = 0;
        int supo2Score = 0;
        int supo3Score = 0;
        for(int i = 0 ; i<answers.length; i++){
            if(supo1[i%supo1.length]==answers[i])supo1Score ++;
            if(supo2[i%supo2.length]==answers[i])supo2Score ++;
            if(supo3[i%supo3.length]==answers[i])supo3Score ++;
        }
        int max = Math.max(supo1Score, Math.max(supo2Score, supo3Score));

        List<Integer> answer = new ArrayList<>();
        if(max == supo1Score)answer.add(1);
        if(max == supo2Score)answer.add(2);
        if(max == supo3Score)answer.add(3);
    
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}