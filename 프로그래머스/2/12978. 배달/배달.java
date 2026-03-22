import java.util.*;
import java.io.*;
class Node{
    int town;
    int time;
    Node(int town, int time){
        this.town = town;
        this.time = time;
    }
}
class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<Node>[] map = new LinkedList[N];
        
        int[] dist = new int[N];

        for(int i = 0 ; i<N;i++){
            map[i] = new LinkedList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        
        for(int[] r : road){
            map[r[0]-1].add(new Node(r[1]-1, r[2]));
            map[r[1]-1].add(new Node(r[0]-1, r[2]));
        }
        bfs(dist, map);
        for(int dis : dist){
            if(dis<=K)answer++;
        }
        return answer;
    }
    public void bfs(int[] dist, List<Node>[] map){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int town = node.town;
            int time = node.time;
            
            for(Node li : map[town]){
                
                if(dist[li.town]<=li.time + time) continue;
                dist[li.town] = Math.min(dist[li.town], time+li.time);
                q.add(new Node(li.town, time+li.time));
            }
        }
        
    }
}