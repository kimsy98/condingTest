import java.util.*;

class Solution {

    static List<Integer>[] arr;
    static int answer = 0;

    public int solution(int n, int[][] edge) {
        arr = new ArrayList[n+1];
        
        for(int i =0; i<=n;i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i =0; i<edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            
            arr[start].add(end);
            arr[end].add(start);
        }
        
        bfs(n);
        
        return answer;
    }
    void bfs(int n){
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        q.add(new Node(1,0));
        int max = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int v = node.v;
            int l = node.length;
            if(max==l){
                answer++;
            }else{
                answer = 1;
                max++;
            }
            for(int i =0; i<arr[v].size();i++){
                int end = arr[v].get(i);
                if(visit[end])continue;
                visit[end] = true;
                q.add(new Node(end, l+1));
            }
        }
    }
    public static class Node{
        int length;
        int v;
        Node(int v, int length){
            this.v = v;
            this.length = length;
        }
    }
    
}