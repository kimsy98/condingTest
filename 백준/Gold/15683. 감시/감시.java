import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	
	static int n,m;
	static int[][] map;
	static ArrayList<Node> cctv;
	static int res;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[][][] type_dir = {{{0}}, {{0}, {1}, {2}, {3}}, {{2, 3}, {0, 1}},
			{{0, 3}, {1, 3}, {1, 2}, {0, 2}},
			{{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
			{{0, 1, 2, 3}}};
	
	private static class Node{
		int x;
		int y;
		int cNum;
		
		public Node(int x, int y, int cNum) {
			this.x = x;
			this.y = y;
			this.cNum = cNum;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		cctv = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int x = Integer.parseInt(st.nextToken());
				map[i][j] = x;
				if(x!=0&&x!=6) {
					cctv.add(new Node(i,j,x));
				}else if(x==0)res++;
			}
		}
		
		
		combi(0,map,cctv.size());
		System.out.println(res);
	}

	private static void combi(int cnt, int[][] map, int r) {
		if(cnt==r) {
			check(map);
			return;
		}
		int cctv_type = cctv.get(cnt).cNum;
		int x = cctv.get(cnt).x;
		int y = cctv.get(cnt).y;
		
		for (int i = 0; i < type_dir[cctv_type].length; i++) {
			int[][] map_copy = new int[n][m];
			for (int j = 0; j < n; j++) {
				map_copy[j] =map[j].clone();
			}
			
			for (int j = 0; j < type_dir[cctv_type][i].length; j++) {
				
				int dir = type_dir[cctv_type][i][j];
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				while(true) {
					if(nx < 0 || nx >= n || ny < 0 || ny >= m)break;
					
					if(map[nx][ny]==6)break;
					
					map_copy[nx][ny] = -1;
					nx+=dx[dir];
					ny+=dy[dir];
					
					
				}
						
			}
			combi(cnt+1,map_copy,r);
		}
	}
	private static void check(int[][] map) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]==0)ans++;
			}
		}
		res = Math.min(ans, res);
	}

}