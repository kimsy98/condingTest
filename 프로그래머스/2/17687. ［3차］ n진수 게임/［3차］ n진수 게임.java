class Solution {
    public String solution(int n, int t, int m, int p) {
        //n :진법, t :구할 숫자 개수, m :총 인원 수, p :자신의 차례 
        String answer = "";
        StringBuilder all =new StringBuilder();
        for(int i = 0; i<m*t; i++){
            StringBuilder temp = new StringBuilder();
            
            if(i==0){
                all.append("0");
                continue;
            }
            int num = i;
            while(num>0){
                int decNum = num%n;
                num = num/n;
                temp.append(changeBase(decNum));
            }
            for(int j= temp.length()-1; j>=0; j--){
                all.append(temp.charAt(j));
            }
        }
        for(int i =0; i<t; i++){
            answer+=all.charAt(p+m*i-1);
        }
        
        return answer;
    }
    
    public String changeBase(int decNum){
        if(decNum<10){
            return Integer.toString(decNum);
        }else if(decNum == 10){
            return "A";
        }else if(decNum == 11){
            return "B";
        }else if(decNum == 12){
            return "C";
        }else if(decNum == 13){
            return "D";
        }else if(decNum == 14){
            return "E";
        }else{
            return "F";
        }
    }
}