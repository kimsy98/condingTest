import java.util.Scanner;

public class Main {
	static int k ;
	static int[] coin;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n  =sc.nextInt();
		k = sc.nextInt();
		
		coin = new int[n];
		int[] dp  = new int[k+1];
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();	
			for (int j = 1; j <= k; j++) {
				if(j>=coin[i]) {
					dp[j] = dp[j]+dp[j-coin[i]];	
				}
				
			}
		}

		System.out.println(dp[k]);

	}



}