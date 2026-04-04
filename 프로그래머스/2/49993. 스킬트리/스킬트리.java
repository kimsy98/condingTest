class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int skillIdx = 0;
        boolean check = true;
                
        for(String skillTree : skill_trees){
            skillIdx = 0;
            check = true;
            for(char s : skillTree.toCharArray()){
                int idx = skill.indexOf(s); 
                if(idx==-1)continue;
                if(skillIdx==idx)skillIdx++;
                else{
                    check = false;
                    break;
                }
                
            }   
            if(check) answer++;
            
        }
        
        return answer;
    }
}