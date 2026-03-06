import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees){
            boolean check = true;
            int nowIdx = 0;
            
            for(char s : skill_tree.toCharArray()){
                int skillIdx = skill.indexOf(s);
                if(skillIdx==-1)continue;
                if(skillIdx==nowIdx){
                    nowIdx++;
                }else{
                    check = false;
                    break;
                }
                
            }
            if(check) answer++;
        }
        
        return answer;
    }
}