import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	 static class Node{
		int end, l;
		public Node(int end, int l) {
			this.end = end;
			this.l = l;
		}
	}
	static int length=0;
	static int n,m;
	static List<Node> li[];
	static boolean visit[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		li = new ArrayList[n+1];
		visit = new boolean[n+1];
		
		for (int i = 0; i <=n; i++) {
			li[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			li[s].add(new Node(e,0));
			li[e].add(new Node(s,0));
			
		}
		
		bfs();
		

	}
	static int[] count;
	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		count = new int[n+1];
		visit[1] = true;
		q.add(new Node(1,0));
		int max = 0;
		int idx = n;
		while(!q.isEmpty()) {
			Node n =  q.poll();
			int s = n.end;
			int l = n.l;
			
			for (int i = 0; i < li[s].size(); i++) {
				Node node= li[s].get(i);
				int end = node.end;
				if(!visit[end]) {
					visit[end] = true;
					q.add(new Node(end,l+1));
					count[end] = l+1;


					if(max<l+1) {
						max = l+1;
					}
					
				}
				

			}			
		}
		int size = 0;
		int check = 0;
		for (int i = 1; i <= n; i++) {
			if(count[i]==max) {
				size++;
				check++;
				if(check==1)idx = i;
			}
		}
		
		System.out.println(idx+" "+max+" "+size );
		
	}

}