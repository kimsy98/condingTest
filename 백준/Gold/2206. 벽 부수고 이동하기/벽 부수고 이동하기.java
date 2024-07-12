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
	static boolean[][][] check;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int res=0;
	static class Node{
		int x,y,l;
		boolean remove;
		Node(int x, int y,int l, boolean remove){
			this.x = x;
			this.y = y;
			this.l = l;
			this.remove = remove;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		check = new boolean[n][m][2];
		
		for (int i = 0; i < n; i++) {
			char[] num = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				arr[i][j] =num[j]-'0'; 
			}
		}
		
		bfs(0);
		
		if(res==0) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
		
		
	}

	static void bfs(int cnt) {
		Queue<Node> q = new LinkedList<>();
		check[0][0][0] = true;
		q.add(new Node(0,0,1,false));
		
		while(!q.isEmpty()) {
			
			Node node = q.poll();
			
			if(node.x==n-1&&node.y==m-1) {
				res = node.l;
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = node.x +dx[i];
				int ny = node.y +dy[i];
				
				if(nx<0||nx>=n||ny<0||ny>=m)continue;
				if(arr[nx][ny]==0) {
					if(!node.remove&&!check[nx][ny][0]) {
						check[nx][ny][0] = true;
						q.add(new Node(nx,ny,node.l+1,false));
					}else if(node.remove&&!check[nx][ny][1]){
						check[nx][ny][1] = true;
						q.add(new Node(nx,ny,node.l+1,true));
						
					}
				}else if(arr[nx][ny]==1){
					if(!node.remove) {
						check[nx][ny][1] = true;
						q.add(new Node(nx,ny,node.l+1,true));
					}
				}
				
				
			}
			
		}
		
		
	}

}