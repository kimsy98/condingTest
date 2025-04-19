class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, sequence.length-1};
        int size  = sequence.length;
        int l = 0; 
        int r = 0;
        int num = sequence[0];
        while(l<=r&&l<size&&r<size){
            
            if(num<k){
                r++;
                if(r>=size)break;
                num+= sequence[r];   
            }else if(num > k){
                num-=sequence[l];
                l++;
            }else{
                if(r-l+1< answer[1]-answer[0]+1){
                    answer = new int[] {l,r};
                }else if(r-l+1==answer[1]-answer[0]+1){
                    if(l<answer[0]){
                        answer = new int[] {l,r};
                    }
                }

                if(r<size-1){
                    r++;
                    num += sequence[r];
                }else{
                    num -= sequence[l];
                    l++;
                }
            }
        }
        
        return answer;
    }
}