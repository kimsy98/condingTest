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
    int[] sArr;
    int[] aArr;
    int[] bArr;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<Node>[] map = new ArrayList[n];
        for(int i = 0 ; i<n; i++){
            map[i] = new ArrayList<>();
        }
        sArr = new int[n];
        aArr = new int[n];
        bArr = new int[n];
        Arrays.fill(sArr, 100000*200);
        Arrays.fill(aArr, 100000*200);
        Arrays.fill(bArr, 100000*200);
        sArr[s-1] = 0;
        aArr[a-1] = 0;
        bArr[b-1] = 0;
        
        for(int[] fare : fares){
            map[fare[0]-1].add(new Node(fare[1]-1,fare[2]));
            map[fare[1]-1].add(new Node(fare[0]-1,fare[2]));
        }
        
        dijkstra(sArr, map, s-1);
        dijkstra(aArr, map, a-1);
        dijkstra(bArr, map, b-1);

        for(int i = 0; i<n; i++){
            answer = Math.min(answer, sArr[i]+aArr[i]+bArr[i]);
        }
        
        
        return answer;
    }
    public void dijkstra(int[] arr, List<Node>[] map, int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.w - o2.w);
        
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node no = pq.poll();
            int nowNode = no.node;
            int nowW = no.w;
            
            if(arr[nowNode]<nowW)continue;
            
            for(int i = 0; i<map[nowNode].size(); i++){
                Node nextNode = map[nowNode].get(i);
                if(arr[nextNode.node]<nowW+nextNode.w)continue;
                arr[nextNode.node] = Math.min(arr[nextNode.node], nowW+nextNode.w); 
                pq.add(new Node(nextNode.node, arr[nextNode.node]));
            }
            
        }
    }
}