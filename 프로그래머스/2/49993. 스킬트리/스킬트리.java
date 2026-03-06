import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i<skill.length(); i++){
            q.add(skill.charAt(i));
        }
        
        List<Queue<Character>> skillList= new ArrayList<>();
        
        for(int i = 0; i< skill_trees.length; i++){
            skillList.add(new LinkedList<>());
            for(int j = 0; j<skill_trees[i].length(); j++){
                if(q.contains(skill_trees[i].charAt(j))){
                    skillList.get(i).add(skill_trees[i].charAt(j));
                }
            }
            
        }
        
        for(Queue<Character> li : skillList){
            Queue<Character> tempQ = new LinkedList<>();
            for(int i = 0; i<skill.length(); i++){
                tempQ.add(skill.charAt(i));
            }
            while(!tempQ.isEmpty()&&!li.isEmpty()){
                if(tempQ.peek()==li.peek()){
                    tempQ.poll();
                    li.poll();
                }else break;
            }
            if(li.isEmpty())answer++;
            // System.out.println(li);
            
        }        
        
        return answer;
    }
}