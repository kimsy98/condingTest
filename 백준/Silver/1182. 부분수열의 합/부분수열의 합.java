import java.util.Scanner;

public class Main {
	
	static int cnt=0;
	static int n,s;
	static int[] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n  = sc.nextInt();
		s = sc.nextInt();
		
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dfs(0,0);

		System.out.println(s==0 ? cnt-1: cnt);
	}
	public static void dfs(int idx, int sum) {
		if(idx==n) {
			if(sum==s)cnt++;
			return;
		}
		dfs(idx+1,sum+arr[idx]);
		dfs(idx+1,sum);
	}

}