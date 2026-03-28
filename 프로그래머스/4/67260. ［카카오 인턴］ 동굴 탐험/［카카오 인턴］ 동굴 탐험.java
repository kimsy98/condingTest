import java.util.*;
class Solution {
    int countRoom =0;
    
    public boolean solution(int n, int[][] path, int[][] order) {

        List<Integer>[] caves = new ArrayList[n];
        boolean[] visit = new boolean[n];
        boolean[] visitLock = new boolean[n];
        int[] key = new int[n];
        int[] lock = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i<n; i++){
            caves[i] = new ArrayList<>();
        }
        for(int[] p : path){
            caves[p[0]].add(p[1]);
            caves[p[1]].add(p[0]);
        }
        
        for(int[] o: order){
            key[o[0]] = o[1];
            lock[o[1]] = o[0];
        }
        if(lock[0]!=0)return false;
        q.add(0);
        visit[0] = true;
    
        while(!q.isEmpty()){
            int now = q.poll();
            countRoom++;
            
            if(key[now]!=0){
                int target = key[now];
                lock[target] = 0;
                
                if(visitLock[target]){
                    visit[target] = true;
                    q.add(target);
                }
            }
            
            for(int i =0; i<caves[now].size(); i++){
                if(visit[caves[now].get(i)]) continue;
                if(lock[caves[now].get(i)]!=0){
                    visitLock[caves[now].get(i)]=true;
                    continue;
                }
                visit[caves[now].get(i)] = true;
                q.add(caves[now].get(i));
            }
        }
        if(countRoom==n)return true;
        else return false;
    }
}