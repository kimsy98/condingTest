import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int[] nx = {0,1,-1,0};
	static int[] ny = {1,0,0,-1};
	static int answer=0;
//	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		map = new int[n][m];
		visit  = new boolean[n][m];
		
		for(int i =0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				if(map[i][j]==1)cnt++;
				
			}
		}
		combi(0,0);
		System.out.println(answer);
		
	}
	static void combi(int st, int wall) {
		if(wall==3) {
			count();
			return;
		}
		for(int i = st; i<n*m;i++) {
			if(!visit[i/m][i%m]&&map[i/m][i%m]==0) {
				 visit[i/m][i%m] = true;
				 map[i/m][i%m] = 1;
				 combi(i,wall+1);
				 visit[i/m][i%m] = false;
				 map[i/m][i%m] = 0;
				 
			}
		}
	}
	static class position{
		int x;
		int y;
		position(int x, int y){
			this.x = x;
			this.y=  y;
		}
	}
	static void count() {
		int cnt =0;
		Queue<position> q = new LinkedList<>();
		int[][] copyMap = new int[n][m];
		boolean[][] copyVisit = new boolean[n][m];
		for(int i =0; i<n; i++) {
			copyMap[i] = map[i].clone();
//			copyVisit[i] = visit[i].clone();
		}
		for(int i =0; i<n; i++) {
			for(int j =0; j<m; j++) {
				if(copyMap[i][j]==2)q.add(new position(i, j));
			}
		}
		while(!q.isEmpty()) {
			position pos = q.poll();
			int x = pos.x;
			int y = pos.y;
			
			for(int i =0; i<4; i++) {
				int dx = x+nx[i];
				int dy = y+ny[i];
				
				if(dx<0||dx>=n||dy<0||dy>=m)continue;
				if(copyVisit[dx][dy]||copyMap[dx][dy]==1)continue;
				
				copyMap[dx][dy] = 2;
				copyVisit[dx][dy] = true;
				q.add(new position(dx, dy));
			}
		}
		for(int i =0; i<n; i++) {
			for(int j =0; j<m; j++) {
				if(copyMap[i][j]==0) cnt++;
			}
		}
		answer = Math.max(answer, cnt);
		
	}

}