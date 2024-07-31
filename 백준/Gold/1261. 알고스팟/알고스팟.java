import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int i , j;
	int wall;
	public Node(int i , int j, int wall){
		this.i = i;
		this.j = j;
		this.wall = wall;
	}
	@Override
	public int compareTo(Node o) {
		return this.wall - o.wall;
	}
}
public class Main {
	static int n,m;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		m  =Integer.parseInt(st.nextToken());
		n =Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		check = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			char[] c= br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				arr[i][j] = c[j]-'0';
			}
		}
		int res = bfs(0,0);
		System.out.println(res);
	}

	static int bfs(int i, int j) {
		Queue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(i,j,0));
		check[i][j] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.i == n-1 &&node.j == m-1) {
				return node.wall;
			}
			for (int k = 0; k < 4; k++) {
				
				int nx = node.i +dx[k];
				int ny = node.j +dy[k];
				int wall = node.wall;
				
				if(nx<0||nx>=n||ny<0||ny>=m)continue;
				if(check[nx][ny])continue;
				
				check[nx][ny] = true;
				if(arr[nx][ny]==0) {
					q.add(new Node(nx,ny,wall));
				}else {
					q.add(new Node(nx,ny,wall+1));
				}
			}
		}
		
		return 0;
	}

}