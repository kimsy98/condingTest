import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] stu = new int[n+1];
        Arrays.fill(stu,1);
        stu[0] = 0;
        
        for(int re: reserve){
            stu[re] = 2;
        }
        for(int lo : lost){
            stu[lo]-=1;
        }
        for(int i =1; i<=n-1;i++){
            if(stu[i+1]==0&&stu[i]==2){
                stu[i+1]++;
                stu[i]--;
                i++;
            }else if(stu[i]==0&&stu[i+1]==2){
                stu[i]++;
                stu[i+1]--;
                i++;
            }
        }
        
        for(int num : stu){
            if(num>0) answer++;
        }
        
        for(int i =n; i>=2;i--){
            if(stu[i-1]==0&&stu[i]==2){
                stu[i-1]++;
                stu[i]--;
                i++;
            }else if(stu[i]==0&&stu[i-1]==2){
                stu[i]++;
                stu[i-1]--;
                i++;
            }
        }
        int check=0;
        for(int num : stu){
            if(num>0) check++;
        }
        answer = Math.max(answer, check);
        return answer;
    }
}