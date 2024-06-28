import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] arr;
	static boolean[][] check;
	static int cnt=0;
	static class Node{
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y= y;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		
		System.out.println(cnt);
		
	}
	static void dfs(int start, int wall) {
		if(wall==3) {
			count();
			return;
		}
		for (int i = start; i <n*m ; i++) {
			if(!check[i/m][i%m]&&arr[i/m][i%m]==0) {
				check[i/m][i%m] = true;
				arr[i/m][i%m] = 1;
				dfs(i,wall +1);
				arr[i/m][i%m] = 0;
				check[i/m][i%m] = false;
			}
		}
	}
	static void count() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];
		int[][] arrCopy = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			arrCopy[i] = arr[i].clone();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]==2)q.add(new Node(i,j));
			}
		}
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = node.x+dx[i];
				int ny = node.y+dy[i];
				
				if(nx<0||nx>=n||ny<0||ny>=m)continue;
				if(visit[nx][ny]||arr[nx][ny]==1)continue;
				
				visit[nx][ny] = true;
				q.add(new Node(nx,ny));
				arrCopy[nx][ny] = 2;
			}
			
		}
		int num = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arrCopy[i][j]==0)num++;
			}
		}
		
		cnt = Math.max(num, cnt);
		
	}

}