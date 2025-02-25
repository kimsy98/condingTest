class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int l = 0;
        int h = 0;

        for(int[] size : sizes){
            l = Math.max(l, Math.max(size[0],size[1]));
            h = Math.max(h, Math.min(size[0], size[1]));
        }
        answer = l*h;
        return answer;
    }
}