class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int cnt = 0;
            answer[0]++;
            for(int i =0; i<s.length(); i++){
                if(s.charAt(i)=='1')cnt++;
            }
            answer[1]+=s.length()-cnt;
            s="";
            while(cnt>0){
                int check = cnt%2;
                cnt = cnt/2;
                if(check==1)s = "1"+s;
                else s = "0"+s; 
            }
            
        }

        
        return answer;
    }
}