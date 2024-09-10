import java.util.Scanner;

public class Main {	
	static int[][] graph;
	static int V;
	static int E;
	static boolean[] visited;
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		V = sc.nextInt();
		E = sc.nextInt();
		graph = new int[V+1][V+1];
		visited = new boolean[V+1];
	
	
		int a, b;
		for (int i = 0; i < E; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
	
			// 간선 연결
			graph[a][b] = graph[b][a] = 1;
		}
	
	
		for (int i = 1; i <= V; i++) {
			if (visited[i] == false) {
				dfs(i);
				result++;
			}
		}
	
		System.out.println(result);
	}
	
	
	public static void dfs(int index) {
		if(visited[index] == true)
			return;
		else {
			visited[index] = true;
			for(int i = 1; i <= V; i++) {
				if(graph[index][i] == 1) {
					dfs(i);
				}
			}
		}
	}
}