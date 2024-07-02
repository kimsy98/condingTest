import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n,r,q;
	static List<Integer>[] list;
	static int[] dp;
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br  = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		dp = new int[n+1];
		check = new boolean[n+1];
		list = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i <n-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
			
		}
		
		check[r] = true;
		dp(r);
		
		for (int i = 0; i < q; i++) {
			int u = Integer.parseInt(br.readLine());
			System.out.println(dp[u]);
		}
	}

	private static int dp(int idx) {
		int res = 1;
		
		if(dp[idx]==0) {
			List<Integer> tree = list[idx];
			for (Integer i : tree) {
				if(!check[i]) {
					check[i] = true;
					res+=dp(i);
				}
			}
			dp[idx] = res;
		}
		
		return dp[idx];
	}

}