import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;



/**
 * 
 * 녹일 때는 BFS 로 돌고 덩어리 셀때는 dfs로 돌아보자
 * bfs1년 녹이고 그다음에 dfs로 넘어가서 세고 두 덩어리 이상 안될때는 어카냐?
 * @author SSAFY
 *
 */
public class Main {
	
	static class Node{
		int r,c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		
	}
	
	static int n,m;
	static int year;
	static int landCnt;
	static int[][] map;
	static int[][] copymap;
	static boolean[][] visit;
	static Queue<Node> q = new ArrayDeque<>();
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n][m];
		map = new int[n][m];
		copymap = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	
			}
		}
		
		bfs();
		if(landCnt<=1) {
			System.out.println(0);
		}else {
			
			System.out.println(year);
		}
		
		
		
	}
	private static void bfs() {
		
		
		
		while(true) {
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]>0)q.add(new Node (i,j));
				}
			}
			if(q.size()==0)break;
			copymap = new int[n][m];

			while (!q.isEmpty()) {
				Node node = q.poll();
				
				int row = node.r;
				int col = node.c;
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nr = row + dx[i];
					int nc = col + dy[i];
					if(nr<0||nr>=n||nc<0||nc>=m||map[nr][nc]>0)continue;
					cnt++;
				}
				copymap[row][col]= cnt;
				
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(copymap[i][j]!=0) {
						map[i][j] = map[i][j] - copymap[i][j];
					}	
				}
			}
			
//			System.out.println("map change :");
//			for (int i = 0; i < n; i++) {
//				
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			
			
			
			year++;
			landCnt = 0;
			visit = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]>0 && !visit[i][j]) {
						
//						System.out.println("landCnt : " + landCnt);
						landCntdfs(i,j);
						landCnt++;
					}
				}
			}
			
			if(landCnt>=2)break;
		}
		
	}
	private static void landCntdfs(int row, int col) {
		visit[row][col] = true;
//		System.out.print(row+" " +col+"::");
//		for (int i = 0; i < n; i++) {
//			
//			System.out.println(Arrays.toString(visit[i]));
//		}
		
		for (int k = 0; k < 4; k++) {
			int nr = row + dx[k];
			int nc = col + dy[k];
			if(nr<0||nr>=n||nc<0||nc>=m)continue;
			if(map[nr][nc]>0&&!visit[nr][nc]) {
				landCntdfs(nr,nc);
			}
	
		}
		
		
	}

}
