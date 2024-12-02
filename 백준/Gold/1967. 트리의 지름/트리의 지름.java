import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Node>[] li;
	static boolean[] vis;
	static int max;
	static class Node{
		int e;
		int weight;
		Node(int e, int weight){
			this.e = e;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		li = new ArrayList[n+1];
		for ( int i =0; i<n+1;i++) {
			li[i] = new ArrayList<>();
		}
		for(int i =1; i<=n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			li[start].add(new Node(end,w));
			li[end].add(new Node(start, w));
		}
		for(int i =1; i<=n; i++) {
			vis = new boolean[n+1]; 
			vis[i] = true;
			dfs(i,0);
		}
		System.out.println(max);
		
		
		
	}
	static void dfs(int num, int weight) {
        for(Node node : li[num]){
            if(!vis[node.e]){
                vis[node.e] = true;
                dfs(node.e, weight + node.weight);
            }
        }
        max = Math.max(max,weight);
	}

}