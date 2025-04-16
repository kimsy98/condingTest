import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        boolean check = true;
        while(check){
            // System.out.println(max);
            for(int i =0; i<arr.length-1; i++){
                if(max%arr[i]==0){
                    answer = max;
                    check = false;
                }else{
                    check = true;
                    break;
                }
            }
            if(check)max+= arr[arr.length-1];
        }
        return answer;
    }
}