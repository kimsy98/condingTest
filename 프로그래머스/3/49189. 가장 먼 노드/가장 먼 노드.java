import java.util.*;
class Solution {
    static int answer = 0;
    static int depth = 0;
    public int solution(int n, int[][] edge) {
        List<Integer>[] arr = new List[n];
        for(int i =0; i<n; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            arr[e[0]-1].add(e[1]-1);
            arr[e[1]-1].add(e[0]-1);
        }
        
        bfs(n,edge, arr);
        
        
        return answer;
    }
    static int cnt = 0;
    static void bfs(int n, int[][] edge, List<Integer>[] arr){
        boolean[] visit = new boolean[n];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,1));
        visit[0] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            int st = node.a;
            int dep = node.dep;
            if(dep> depth){
                depth = dep;
                cnt=0;
            }
            cnt++;
            for(int i =0; i<arr[st].size(); i++){
                if(visit[arr[st].get(i)])continue;
                visit[arr[st].get(i)] = true;
                q.add(new Node(arr[st].get(i), dep+1));
            }


        }
        answer = cnt;

    }
    static class Node{
        int a;
        int dep;
         Node(int a, int dep){
            this.a = a;
            this.dep = dep;
        }
    }
}