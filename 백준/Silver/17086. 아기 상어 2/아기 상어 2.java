import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		int x,y,cnt;
		public Node(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int n,m;
	static int max=0;

	static int[][] arr;
	static boolean[][] check;
    static int dx[]= {0,0,1,-1,1,1,-1,-1};
	static int dy[]= {1,-1,0,0,1,-1,-1,1};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int [n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]==0) {
					int num = bfs(new Node(i,j,0));
					max = Math.max(max, num);
					
				}
			}
		}
		System.out.println(max);

	}

	static int bfs(Node node) {
		Queue<Node> q = new LinkedList<>();
		check = new boolean[n][m];
		
		q.add(node);
		while(!q.isEmpty()) {
			Node nodes = q.poll();
						
			for (int i = 0; i < 8; i++) {
				int nx = nodes.x+ dx[i];
				int ny = nodes.y+ dy[i];
				int count = nodes.cnt+1;
				if(nx<0||nx>=n||ny<0||ny>=m)continue;
				if(check[nx][ny])continue;
				if(arr[nx][ny]==1) return count;
				q.add(new Node(nx,ny,count));
				check[nx][ny] = true;
				
			}

			
		}
		return 0;
		
	}

}