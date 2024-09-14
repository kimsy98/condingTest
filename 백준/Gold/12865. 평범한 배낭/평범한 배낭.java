import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();//물건 종류
		int k = sc.nextInt();//배낭 무게
		
		int[] weight = new int[n+1];
		int[] profit = new int[n+1];
		int[][] dp = new int[n+1][k+1];
		
		for (int i = 1; i <=n; i++) {
			weight[i] = sc.nextInt();
			profit[i] = sc.nextInt();
		}
		
		
		for (int i = 1; i <=n; i++) {	//넣을 물건 종류 증가중
			for (int j = 1; j <= k; j++) {//가방 무게 증가중
				
				if(j<weight[i]) {
					dp[i][j] = dp[i-1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], profit[i]+dp[i-1][j-weight[i]]);
				}
				
				
			}
		}
		System.out.println(dp[n][k]);
		

	}

}
