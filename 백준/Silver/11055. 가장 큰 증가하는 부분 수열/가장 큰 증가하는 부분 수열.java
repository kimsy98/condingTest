import java.util.Scanner;

public class Main {

	static int n;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		n=  sc.nextInt();
		
		arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i <n; i++) {
			IS(i);
		}
		int res=0;
		for (int i = 0; i < n; i++) {
			res = Math.max(dp[i],res);
		}
		System.out.println(res);
	}
	private static void IS(int i) {
		// TODO Auto-generated method stub
		if(dp[i]==0) {
			dp[i] = arr[i];
			
			for (int j = i-1; j >= 0; j--) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
			}
		}
	}

}