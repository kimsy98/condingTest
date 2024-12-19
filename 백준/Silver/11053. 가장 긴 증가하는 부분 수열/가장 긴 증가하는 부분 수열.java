import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] sqe;
	static int[] dp;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		sqe = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			sqe[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(dp, 1);
		
		
		for(int i=1; i<n;i++) {
//			int max = 0;
			for(int j=0; j<i;j++) {
				if(sqe[i]>sqe[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		for(int num : dp) {
			ans = Math.max(num, ans);
		}
		System.out.println(ans);
	}

}