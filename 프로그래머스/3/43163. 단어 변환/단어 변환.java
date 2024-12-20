class Solution {
    static boolean[] vis;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        vis = new boolean[words.length];
        dfs(begin, target, words,0);
        
        if(answer==Integer.MAX_VALUE) return 0;
        else return answer;
    }
    static void dfs(String be, String tar, String[] words, int cnt){
        if(be.equals(tar)){
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i=0; i<words.length; i++){
            int check=words[i].length();
            if(vis[i])continue;
            for(int j =0; j<words[i].length();j++){
                if(be.charAt(j)==words[i].charAt(j)){
                    check--;
                }
            }
            if(check==1){
                vis[i] = true;
                // System.out.println(words[i]);
                dfs(words[i], tar, words, cnt+1);
                vis[i] = false;
            }
            

            
        }
    }
}