import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] arr;
	static boolean[][] vis;
	static int n;
	static int[] ans = new int[2];
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][];
		vis = new boolean[n][n];
		for(int i =0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<n; i++){
			for(int j =0; j<n ; j++) {
				if(vis[i][j])continue;
				ans[0]++;
				bfs(i,j,arr[i][j]);
			}
		}

		for(int i=0; i<n; i++){
			for(int j =0; j<n ; j++) {
				if(arr[i][j]=='G')arr[i][j]='R';
			}
		}
		vis = new boolean[n][n];
		for(int i=0; i<n; i++){
			for(int j =0; j<n ; j++) {
				if(vis[i][j])continue;
				ans[1]++;
				bfs(i,j,arr[i][j]);
			}
		}
		System.out.println(ans[0]+" "+ans[1]);
	}

	static void bfs(int i, int j, char c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j,c});
		vis[i][j] = true;
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			for(int k = 0; k<4; k++) {
				int nx = pos[0]+dx[k];
				int ny = pos[1]+dy[k];
				if(nx<0||nx>=n||ny<0||ny>=n)continue;
				if(vis[nx][ny]||arr[nx][ny]!=c)continue;
				vis[nx][ny] = true;
				q.add(new int[] {nx, ny});
			}
		}
		
	}
}