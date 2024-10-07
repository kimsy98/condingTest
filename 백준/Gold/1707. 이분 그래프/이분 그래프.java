import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visit;
	static boolean ans;
	static Node[] node;
	
	static class Node{
		int idx;
		int color;
		List<Node> child = new ArrayList<>();
		
		public Node(int idx) {
			this.idx = idx;
		}
		
		public void setColor(int color) {
			this.color = color;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc  = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			node = new Node[v+1];
			visit = new boolean[20001];
			
			for (int j = 0; j <= v; j++) {
				node[j] = new Node(j);
			}
			
			ans = true;
			
			//연결 그래프
			int a,b;
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				node[a].child.add(node[b]);
				node[b].child.add(node[a]);	
			}
			
			for (int j = 1; j <=v; j++) {
				if(!visit[j]) {
					visit[j] = true;
					node[j].setColor(1);
					if(!bfs(j)) {
						ans = false;
						break;
					}
				}
			}
			
			System.out.println(ans?"YES":"NO");
			
		}
		
	}
	static boolean bfs(int idx) {
		Queue<Node> q = new LinkedList<>();
		q.add(node[idx]);
		
		while(!q.isEmpty()) {
			Node n  = q.poll();
			
			if(check(n)) {
				return false;
			}else {
				for(Node child : n.child) {
					if(!visit[child.idx]) {
						visit[child.idx] = true;
						child.setColor(1-n.color);
						q.add(child);
					}
				}
			}
			
		}
		return true;
		
	}
	
	static boolean check(Node node) {
		for(Node child: node.child) {
			if(visit[child.idx]&&child.color==node.color)return true;
		}
		return false;
	}

}