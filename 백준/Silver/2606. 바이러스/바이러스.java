import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int node, vertex;
	static int[][] gragh;
	static boolean[] visited;
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		node = Integer.parseInt(br.readLine());
		vertex = Integer.parseInt(br.readLine());

		gragh = new int[node + 1][node + 1];
		visited = new boolean[node + 1];

		for (int i =0; i < vertex; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());

			gragh[a][b] = gragh[b][a] = 1;

		}
		visited[1]=true;
		dfs(1);
		System.out.println(cnt);

	}
	private static void dfs(int startNode) {
		
		if(!visited[startNode]) {
			visited[startNode]=true;
			cnt++;
		}
		
		for (int i = 1; i <= node; i++) {
			if(gragh[startNode][i]==1&&!visited[i])dfs(i);//방문 안한곳 조건 넣기
		}
		
	}

}
