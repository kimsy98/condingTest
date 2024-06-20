import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int arr[][];
	static int res[][];
	static boolean check[][];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static class Node {
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		res = new int[n][m];
		check = new boolean[n][m];
		int sx = 0,sy=0;
		for (int i = 0; i < n; i++) {
			st  = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		bfs(sx,sy);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!check[i][j]&&arr[i][j]==1) {
					sb.append(-1+" ");
				}
				else {
					sb.append(res[i][j]+" ");
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	private static void bfs(int x,int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		check[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				if(nx<0||nx>=n||ny<0||ny>=m)continue;
				if(arr[nx][ny]==0||check[nx][ny])continue;
				
				q.add(new Node(nx, ny));
				res[nx][ny] = res[node.x][node.y]+1;
				check[nx][ny] = true;
				
			}	
		}
		

		
	}


}