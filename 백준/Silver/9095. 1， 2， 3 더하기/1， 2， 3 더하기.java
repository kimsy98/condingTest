import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] dp = new int[11];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			int num = sc.nextInt();
			System.out.println(dp[num]);
		}
		
		
	}

}
