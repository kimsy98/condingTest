import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        boolean[] visit = new boolean[routes.length];
        Arrays.sort(routes,(o1,o2)->o1[1]-o2[1]);
        int start = routes[0][1];
        int size = routes.length;
        int idx = 0;
        int checkCnt = size;
        while(checkCnt>0){
            answer++;
            boolean check=false;
            for(int i =0; i<size; i++){
                if(visit[i]) continue;
                if(routes[i][0]<=start){
                    visit[i] = true;
                    checkCnt--;
                } 
                else if(!check){
                    check = true;
                    idx = i;
                }
            }
            start = routes[idx][1];
        }

        return answer;
    }
}