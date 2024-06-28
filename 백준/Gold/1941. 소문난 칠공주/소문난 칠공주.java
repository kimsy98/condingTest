import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

	static class Node {
		int r,c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] arr = new char[5][];
	static boolean[][]check;
	static int[] group= new int[7];
	static int res=0;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		check = new boolean[5][5];
		dfs(0,0);
		System.out.println(res);
		
		
	}
	public static void dfs(int st, int cnt) {
		if(cnt==7) {
			if(possible(group))res++;
			return;
		}
		for (int i = st; i < 25; i++) {
			int x = i/5;
			int y = i%5;
			if(!check[x][y]) {
				check[x][y] = true;
				group[cnt] = i;
				dfs(i,cnt+1);
				check[x][y] =false;
			}
		}
		
	}
	public static boolean possible(int[] group) {
		Queue<Node> q =new LinkedList<>();
		boolean[] visit = new boolean[7];
		q.add(new Node(group[0]/5,group[0]%5));
		visit[0] = true;
		int count =1;
		int scnt= 0;
		while(!q.isEmpty()) {
			Node no = q.poll();
			if(arr[no.r][no.c]=='S')scnt++;
			for (int i = 0; i < 4; i++) {
				int nx = no.r +dx[i];
				int ny = no.c +dy[i];
				for (int j = 1; j < 7; j++) {
					if(!visit[j]&&nx==group[j]/5&&ny==group[j]%5) {
						visit[j] = true;
						q.add(new Node(nx,ny));
						count++;
					}
				}
				
				
			}
		}
		if(count==7) {
			if(scnt>=4)return true;
		}
		return false;
	}

}