import java.util.*;
class Node{
    int node;
    int charge;
    
    Node(int node, int charge){
        this.node = node;
        this.charge = charge;
    }
}
class Solution {
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        List<Node>[] taxiMap = new ArrayList[n];
        int[] minArr = new int[n];
        Arrays.fill(minArr, Integer.MAX_VALUE);
        minArr[s-1] = 0;
        int[] minArrA = new int[n];
        Arrays.fill(minArrA, Integer.MAX_VALUE);
        minArrA[a-1] = 0;
        int[] minArrB = new int[n];
        Arrays.fill(minArrB, Integer.MAX_VALUE);
        minArrB[b-1] = 0;
        for(int i =0; i<n; i++){
            taxiMap[i] = new ArrayList<>();
        }
        for(int[] fare : fares){
            taxiMap[fare[0]-1].add(new Node(fare[1]-1, fare[2])); 
            taxiMap[fare[1]-1].add(new Node(fare[0]-1, fare[2])); 
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.charge-o2.charge);
        pq.add(new Node(s-1, 0));
        while(!pq.isEmpty()){
            Node no = pq.poll();
            int pos = no.node;
            int charge = no.charge;
            for(int i = 0 ; i< taxiMap[pos].size(); i++){
                if(charge+taxiMap[pos].get(i).charge< minArr[taxiMap[pos].get(i).node]){
                    minArr[taxiMap[pos].get(i).node] = charge+taxiMap[pos].get(i).charge;
                    pq.add(new Node(taxiMap[pos].get(i).node, charge+taxiMap[pos].get(i).charge));
                }else continue;
            }
            
        }
        pq.add(new Node(a-1, 0));
        while(!pq.isEmpty()){
            Node no = pq.poll();
            int pos = no.node;
            int charge = no.charge;
            for(int i = 0 ; i< taxiMap[pos].size(); i++){
                if(charge+taxiMap[pos].get(i).charge< minArrA[taxiMap[pos].get(i).node]){
                    minArrA[taxiMap[pos].get(i).node] = charge+taxiMap[pos].get(i).charge;
                    pq.add(new Node(taxiMap[pos].get(i).node, charge+taxiMap[pos].get(i).charge));
                }else continue;
            }
            
        }
        pq.add(new Node(b-1, 0));
        while(!pq.isEmpty()){
            Node no = pq.poll();
            int pos = no.node;
            int charge = no.charge;
            for(int i = 0 ; i< taxiMap[pos].size(); i++){
                if(charge+taxiMap[pos].get(i).charge< minArrB[taxiMap[pos].get(i).node]){
                    minArrB[taxiMap[pos].get(i).node] = charge+taxiMap[pos].get(i).charge;
                    pq.add(new Node(taxiMap[pos].get(i).node, charge+taxiMap[pos].get(i).charge));
                }else continue;
            }
            
        }
        // System.out.println(Arrays.toString(minArr));
        // System.out.println(Arrays.toString(minArrA));
        // System.out.println(Arrays.toString(minArrB));
        // System.out.println(2147483647+);
        
        for(int i = 0; i<n; i++){
            answer = Math.min(minArr[i]+minArrA[i]+minArrB[i], answer);
        }
        return answer;
    }
}