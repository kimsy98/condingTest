import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[][] arr;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];

		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[start][end] = cost;
			arr[end][start] = cost;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			check = new boolean[n+1];
			check[a] = true;
			dfs(a,b,0);
		}
		System.out.println(sb);
		
	}
	static void dfs(int s, int e, int c) {
		// TODO Auto-generated method stub
		if(e==s) {
			sb.append(c+"\n");
		}
		for(int i =1;i<n+1;i++) {
			if(arr[s][i]!=0&&!check[i]) {
				check[i] = true;
				dfs(i,e,c+arr[s][i]);
				check[i] = false;
			}
		}
	}

}