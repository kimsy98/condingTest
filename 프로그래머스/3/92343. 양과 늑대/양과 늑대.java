import java.util.*;

class Solution {

    int solution(int[] info, int[][] edges) {

        int n = info.length, cnt = 0;
        List<Integer> adj[] = new ArrayList[n];

        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<>();

        for(int e[] : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0, 1});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            cnt = Math.max(cnt, cur[0]);
            for(int i=0, bit=1; i<n && bit<=cur[2]; bit=1<<++i) {
                if((cur[2]&bit) > 0) {
                    for(int j : adj[i]) {
                        if((cur[2]&1<<j) > 0 || info[j] == 1 && cur[0]-cur[1] == 1) continue;
                        int next[] = new int[3];
                        next[0] = info[j] == 0 ? cur[0]+1 : cur[0];
                        next[1] = info[j] == 1 ? cur[1]+1 : cur[1];
                        next[2] = cur[2]^1<<j;
                        q.add(next);
                    }
                }
            }
        }
        return cnt;
    }
}
