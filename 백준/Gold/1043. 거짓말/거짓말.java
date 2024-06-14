import java.util.Scanner;

public class Main {
	
	static int n,m;
	static int len;
	static boolean[][] adj;
	static boolean[] t;
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		len = sc.nextInt();
		t = new boolean[n+1];
		adj = new boolean[n+1][n+1];
		
		for (int i = 0; i < len; i++) {
			t[sc.nextInt()] = true;
		}
		int party[][] = new int[m][];
		
		for (int i = 0; i < m; i++) {
			int num = sc.nextInt();
			party[i] = new int[num];
			party[i][0] =sc.nextInt();
			for (int j = 1; j < num; j++) {
				party[i][j] = sc.nextInt();
				adj[party[i][j-1]][party[i][j]] = adj[party[i][j]][party[i][j-1]] = true;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if(t[i])
				dfs(i);
		}
		
		int cnt = 0;
		for (int i = 0; i <m; i++) {
			if(!t[party[i][0]])
				cnt++;
		}
		System.out.println(cnt);
		
	}
	static void dfs(int s) {
		
		for (int i = 1; i <=n; i++) {
			if(adj[s][i]&&!t[i]) {
				t[i] = true;
				dfs(i);
			}
		}
		
	}

}