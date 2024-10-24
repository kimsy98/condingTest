class Solution {
    public int[] solution(int[] answers) {
        int[] ott = new int[3];
        int[] oneArray = {1,2,3,4,5};
        int[] twoArray = {2,1,2,3,2,4,2,5};
        int[] threeArray = {3,3,1,1,2,2,4,4,5,5};

        for(int i = 0; i<answers.length;i++){
            //1번 수포자
            if(oneArray[i%5]==answers[i])ott[0]++;
            //2번 수포자          
            if(twoArray[i%8]==answers[i])ott[1]++;
            //3번 수포자
            if(threeArray[i%10]==answers[i])ott[2]++;
            
        }
        int max = Math.max(ott[0],Math.max(ott[1], ott[2]));
        int cnt = 0;
        for(int num : ott){
            if(max == num)cnt++;
        }
        int[] answer = new int[cnt];
        cnt = 0;
        for(int i = 0; i<3; i++){
            if(max == ott[i]) {
                answer[cnt] = i+1;
                cnt++;
            }
        }
        return answer;
    }
}