import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		int[] dp = new int[11];
		dp[3] = 4;
		dp[1] = 1;
		dp[2] = 2;		

		for (int j = 4; j <=10; j++) {
			dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
		}
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {			
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}

}