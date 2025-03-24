class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        int startNum = n;
        while(startNum>0){
            if(startNum%2==1){
                cnt++;
            }
            startNum = startNum/2;
        }
        boolean check =true;
        while(true){
            n++;
            startNum = n;
            int CheckCnt = 0;
            while(startNum>0){
                if(startNum%2==1){
                    CheckCnt++;
                    // System.out.println(CheckCnt+" // "+startNum+"/// "+cnt);
                }
                startNum = startNum/2;
            }
            
            if(CheckCnt==cnt){
                
                answer = n;
                check = false;
                break;
            } 
        }
        return answer;
    }
}