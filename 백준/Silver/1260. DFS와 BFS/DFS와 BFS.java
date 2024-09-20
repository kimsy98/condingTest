import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int n,m,v;
	static List<Integer>[] adjList;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> que = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		adjList = new List[n+1];
		visit =  new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			 st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		
		for (int i = 1; i <= n; i++) {
			adjList[i].sort((o1,o2) -> o1- o2);
		}
		
//		System.out.println(Arrays.toString(adjList));
		visit[v] = true;
		dfs(v);
		sb.append('\n');
		visit =  new boolean[n+1];
		visit[v] = true;
		bfs(v);
		System.out.println(sb);
	}
	private static void bfs(int from) {

		que.offer(from);
		sb.append(from).append(' ');
		while(!que.isEmpty()) {
			int fm = que.poll();
			for (int i = 0; i < adjList[fm].size(); i++) {
				if(visit[adjList[fm].get(i)])continue;
				visit[adjList[fm].get(i)] = true;
				que.offer(adjList[fm].get(i));
				sb.append(adjList[fm].get(i)).append(' ');
			}
			
		}
		
	}
	private static void dfs(int from) {
		sb.append(from).append(' ');
		
		//기저 조건   ???
		
		
		for (int i = 0; i < adjList[from].size(); i++) {
			if(visit[adjList[from].get(i)])continue;//방문했으면 패스
			visit[adjList[from].get(i)] = true;
			dfs(adjList[from].get(i));
			
		}
	}
}