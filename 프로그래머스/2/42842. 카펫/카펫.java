
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int range = (int)Math.floor(Math.sqrt((double)yellow));
        System.out.println(range);
        for(int i=1;i<=range;i++){
            if(yellow%i==0){
                int width = yellow/i;
                int size = (i+2)*2+(width*2);
                if(size==brown){
                    answer[0] = width+2;
                    answer[1] = i+2;
                    break;
                }
            }
        }
        return answer;
    }
}