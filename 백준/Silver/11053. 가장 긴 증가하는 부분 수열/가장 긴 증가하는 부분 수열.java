import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] dp;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		dp = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			LIS(i);
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res = Math.max(res, dp[i]);
		}
		System.out.println(res);
	}

	private static int LIS(int num) {
		if(dp[num]==0){
			dp[num] = 1;
			
			for (int i = num-1; i >=0; i--) {
				if(arr[i]<arr[num]) {
					dp[num] = Math.max(dp[num], LIS(i)+1);
				}
			}
			
		}
		return dp[num];
		
	}
}