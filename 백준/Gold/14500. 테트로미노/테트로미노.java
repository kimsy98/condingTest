import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int n,m;
	static int[][] map;
	static boolean[][] vis;
	static int ans;
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		vis = new boolean[n][m];
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i<n; i++) {
			for (int j = 0; j < m; j++) {
				vis[i][j] =true;
				dfs(i,j,1,map[i][j]);
				vis[i][j] =false;
			}
		}
		System.out.println(ans);

		
	}
	static void dfs(int i, int j, int dep, int sum) {
		if(dep==4) {
			ans = Math.max(ans, sum);
			return;
		}
		for(int k =0; k<4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			if(nx<0||nx>=n||ny<0||ny>=m)continue;
			if(vis[nx][ny])continue;
			
			if(dep==2) {
				vis[nx][ny] = true;
//				System.out.println(sum+" dep==2v//"+ dep);
				dfs(i,j, dep+1, sum+map[nx][ny]);
				vis[nx][ny] = false;
			}
			vis[nx][ny] = true;
//			System.out.println(sum+" else");
			dfs(nx,ny, dep+1, sum+map[nx][ny]);
			vis[nx][ny] = false;
		}
		
	}
}