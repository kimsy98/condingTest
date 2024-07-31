import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node2 {
	int i,j,l,wcnt;
	
	public Node2(int i, int j, int l, int wcnt){
		this.i = i;
		this.j = j;
		this.l = l;
		this.wcnt = wcnt;
	}
}

public class Main {

	static int n , m, K;
	static int[][] arr;
	static boolean[][][] check;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		check = new boolean[n][m][K+1];
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		int res = bfs(0,0);
		System.out.println(res);
	}

	static int bfs(int i , int j) {
		Queue<Node2> q = new LinkedList<>();
		
		q.add(new Node2(i,j,1,0));
		check[i][j][0] = true;
		
		while(!q.isEmpty()) {
			Node2 node = q.poll();
			
			if(node.i == n-1 &&node.j == m-1) return node.l;
			for (int k = 0; k < 4; k++) {
				int nx = node.i + dx[k];
				int ny = node.j + dy[k];
				
				if(nx<0||nx>=n||ny<0||ny>=m)continue;
				if(arr[nx][ny]==0&&!check[nx][ny][node.wcnt]) {
					check[nx][ny][node.wcnt] = true;
					q.add(new Node2(nx,ny,node.l+1,node.wcnt));
				}
				else {
					if(node.wcnt<K && !check[nx][ny][node.wcnt+1]) {
						check[nx][ny][node.wcnt+1] = true;
						q.add(new Node2(nx,ny,node.l+1,node.wcnt+1));
					}			
				}
			}
		}
		
		return -1;
	}
}