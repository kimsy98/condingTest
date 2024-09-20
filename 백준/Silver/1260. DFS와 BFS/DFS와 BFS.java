import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

	static int n;
	static int m;
	static int v;
	static List<Integer>[] li;
	static Queue<Integer> q = new LinkedList<>();
	
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		li = new List[n+1];
		visit = new boolean[n+1];
	
//		for (List<Integer> l : li) {
//			l = new ArrayList<>();
//		}
		
		for (int i = 0 ; i<=n; i++) {
			li[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			li[start].add(end);
			li[end].add(start);
		}
		
		for (int i = 0; i <=n; i++) {
			li[i].sort((o1,o2)->o1-o2);
		}
		
		dfs(v);
		sb.append('\n');
		bfs(v);
		System.out.println(sb);
	}
	private static void dfs(int from) {
		visit[from] = true;
		sb.append(from+ " ");
		for (int i = 0; i < li[from].size(); i++) {
			if(visit[li[from].get(i)]) continue;
			visit[li[from].get(i)] = true;
			dfs(li[from].get(i));
		}
	}
	private static void bfs(int from) {
		q.offer(from);
		visit = new boolean[n+1];
		visit[from] = true;
		
		while(!q.isEmpty()) {
			int start = q.poll();
			sb.append(start+ " ");
			for (int i = 0; i < li[start].size(); i++) {
				if(visit[li[start].get(i)]) continue;
				visit[li[start].get(i)] = true;
				q.offer(li[start].get(i));
				

			}
		}
	}
}