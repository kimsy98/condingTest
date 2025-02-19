class Solution {
    public int solution(String name) {
        int answer = 0;
        char a = 'N';
        int f = (a-(int)'A'< (int)'Z'-a+1) ? a-(int)'A' : (int)'Z'-a+1;
        System.out.println(f);
        int idx=0;
        int move = name.length()-1;
        for(int i =0; i<name.length();i++){
            answer+=(name.charAt(i)-(int)'A'< (int)'Z'-name.charAt(i)+1) ? name.charAt(i)-(int)'A' : (int)'Z'-name.charAt(i)+1;
            idx = i+1;
            while(idx<name.length()&&name.charAt(idx)=='A')idx++;
            move = Math.min(move, (i*2)+name.length()-idx);
            move = Math.min(move, (name.length()-idx)*2+i);
        }
        
        return answer+move;
    }
}