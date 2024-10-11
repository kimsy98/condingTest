import java.util.Scanner;

public class Main {

	static int n;
	static int s;
	static int[] arr;
	static boolean[] visit;
	static int cnt=0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		
		arr = new int[n];
		visit = new boolean[n];
		
		for(int i=0; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		dfs(0,0,0);
		System.out.println(cnt);
	}
	public static void dfs(int idx, int sum, int now) {
		if(idx>n)return;
		if(sum==s&&idx>0)cnt++;
		
		for (int i = now; i < n; i++) {
			if(visit[i])continue;
			visit[i] = true;
			dfs(idx+1,sum+arr[i], i);
			visit[i] = false;
		}
		
	}

}