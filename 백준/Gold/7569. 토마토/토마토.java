import java.util.*;
import java.io.*;
public class Main {
	static int n, m, h; 
	static int[][][] arr;
	static int[] dx = {0,1,0,-1,0,0};
	static int[] dy = {1,0,-1,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int answer  =Integer.MAX_VALUE;
	static boolean[][][] visit;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[m][n][h];
		int tomatoCnt = 0;
		List<int[]> pos = new ArrayList<>();
		for(int k = 0; k<h; k++) {
			for(int i =0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n; j++) {
					int tomato = Integer.parseInt(st.nextToken());
					if(tomato==0)tomatoCnt++;
					if(tomato==1)pos.add(new int[] {i,j,k});
					arr[i][j][k] = tomato;
				}
			}
		}
		int cnt =0;
//		for(int[] position : pos) {
//			System.out.println(Arrays.toString(position));
//			visit = new boolean[m][n][h];
//			System.out.println(cnt);
//			cnt++;
//			
//		}
		bfs(arr, pos,tomatoCnt);
		System.out.println(answer);

	}
	static void bfs(int[][][] arr, List<int[]> po, int tomatoCnt) {
		Queue<int[]> q =new LinkedList<>();
		visit = new boolean[m][n][h];
		for(int[] pos : po) {
			q.add(new int[] {pos[0], pos[1], pos[2], 0});
			visit[pos[0]][pos[1]][pos[2]] = true;	
		}
		
		int totalCnt = 0;
		int ans = 0;
		while(!q.isEmpty()) {
			int[] dir = q.poll();
//			System.out.println(Arrays.toString(dir));
			ans = Math.max(ans, dir[3]);
			for(int i =0; i<6; i++) {
				int nx = dir[0]+ dx[i];
				int ny = dir[1]+ dy[i];
				int nz = dir[2]+ dz[i];
				int cnt = dir[3];
				if(nx<0||nx>=m||ny<0||ny>=n||nz<0||nz>=h)continue;
				if(visit[nx][ny][nz]||arr[nx][ny][nz]==-1)continue;
				if(arr[nx][ny][nz]==0) {
					visit[nx][ny][nz] = true;
					arr[nx][ny][nz]=1;
					totalCnt++;
					q.add(new int[] {nx,ny, nz, cnt+1});	
				}
				
			}
		}
		if(tomatoCnt==totalCnt) {
			answer = Math.min(answer, ans);
		}else if(tomatoCnt==0) {
			answer = 0;
		}
		else {
			answer = -1;
		}
	}

}