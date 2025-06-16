import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int  n;
	static int[][] rgb;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		rgb = new int[n][3];
		int answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			rgb[i][0] = r;
			rgb[i][1] = g;
			rgb[i][2] = b;
		}

		for(int color = 0; color<3; color++) {
			
			dp = new int[n][3];
			for(int j = 0; j<n; j++) {
				Arrays.fill(dp[j], Integer.MAX_VALUE);
			}
			dp[0][color] = rgb[0][color];
			
			for(int i =0; i<n-1; i++) {
				
				for(int k = 0; k<3; k++) {
					if(dp[i][k]==Integer.MAX_VALUE)continue;
					
					dp[i+1][(k+1)%3]= Math.min(dp[i+1][(k+1)%3], dp[i][k]+rgb[i+1][(k+1)%3]);
					dp[i+1][(k+2)%3]= Math.min(dp[i+1][(k+2)%3], dp[i][k]+rgb[i+1][(k+2)%3]);
				}
				
			}
			
			for(int k = 0; k<3; k++) {
				if(k==color)continue;
				answer = Math.min(answer, dp[n-1][k]);
			}
			
			
		}
		System.out.println(answer);

	}

}
