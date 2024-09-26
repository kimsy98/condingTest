import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int m;
	static int[][] iceberg;
	static boolean[][] visit;
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	static int res=1;
	
	static private class Node{
		int x,y;
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
		
		iceberg = new int[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				iceberg[i][j] = Integer.parseInt(st.nextToken());		
			}
		}
		
		melt();
		System.out.println(res);

	}
	static void melt() {
		int[][] copyarr = new int[n][m];
		visit = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			copyarr[i] = iceberg[i].clone();
		}
		
		//1년 지남
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				int cnt = 0;
				//빙산이면 사방탐색 후 카운트
				if(copyarr[i][j]!=0) {
					for (int dir = 0; dir < 4; dir++) {
						int x = i+dx[dir];
						int y = j+dy[dir];
						if(iceberg[x][y]==0)cnt++;
						
					}
					//복사arr에 저장
					if(iceberg[i][j]-cnt<=0) copyarr[i][j] = 0;
					else copyarr[i][j] = iceberg[i][j] - cnt;
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(copyarr[i]));
//		}

        
		//iceberg 배열에 다시 깊은복사
		for (int i = 0; i < n; i++) {
			iceberg[i] = copyarr[i].clone();
		}

		//빙산 분리되었는지 체크(bfs)		
		int land = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(iceberg[i][j]!=0&& !visit[i][j]) {
					bfs(i,j);
					land++;
				}
			}
		}
	
		//빙하가 분리되거나 다 녹을때까지 재귀
		if(land==0) {
			res = 0;
			return;
		}else if(land>1){
			return;
		}else {
			res++;
			melt();
		}
	
	}
    
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int row = node.x;
			int col = node.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = row+dx[i];
				int ny = col+dy[i];
				if(iceberg[nx][ny]!=0 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.add(new Node(nx, ny));
				}
			}
			
		}
		
	}

}