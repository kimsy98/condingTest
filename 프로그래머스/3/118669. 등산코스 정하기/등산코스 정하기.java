import java.util.*;
class Node{
    int node;
    int w;
    Node(int node, int w){
        this.node = node;
        this.w = w;
    }
}
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] dist = new int[n];
        boolean[] isSummit = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int gate : gates){
            dist[gate-1] = 0;
        }
        for(int summit : summits){
            isSummit[summit-1] = true;
        }
        
        List<Node>[] course = new ArrayList[n];
        for(int i = 0; i< n; i++){
            course[i] = new ArrayList<>();
        }
        
        for(int[] path : paths){
            course[path[0]-1].add(new Node(path[1]-1, path[2]));
            course[path[1]-1].add(new Node(path[0]-1, path[2]));
        }

        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.w-b.w);
        for(int g : gates){
            pq.add(new Node(g-1,0));
        }

        while(!pq.isEmpty()){
            Node no = pq.poll();
            int nowNode = no.node;
            int w = no.w;
            // 이미 더 작은 intensity로 방문했다면 패스
            if (w > dist[nowNode]) continue;
            
            //산봉우리인 경우 탐색 종료
            if(isSummit[nowNode])continue;
            for(int i = 0; i<course[nowNode].size();i++){
                Node nextNode = course[nowNode].get(i);
                int intensity = Math.max(dist[nowNode], nextNode.w);
                
                if (intensity < dist[nextNode.node]) {
                    dist[nextNode.node] = intensity;
                    pq.add(new Node(nextNode.node, intensity));
                }
            }
        }
        
        // 2. 결과 산출 (반드시 산봉우리 중에서만!)
        int minIntensity = Integer.MAX_VALUE;
        int minSummit = -1;

        // 정렬을 먼저 하면 "산봉우리 번호가 낮은 것" 조건을 편하게 맞춤
        Arrays.sort(summits); 
        for (int s : summits) {
            if (dist[s - 1] < minIntensity) {
                minIntensity = dist[s - 1];
                minSummit = s;
            }
        }
        return new int[]{minSummit, minIntensity};
    }
}