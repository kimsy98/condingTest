class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i = 0 ; i< arr1.length; i++){
            for(int k = 0 ; k< arr2[0].length; k++){
                for(int l = 0 ; l< arr2.length; l++){
                    answer[i][k]+=arr1[i][l] * arr2[l][k];
                }
            
            }
        }
        return answer;
    }
}