import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n,m;
	static int[] arr;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		check = new boolean[n];
		
		dfs(0);
		System.out.println(sb);
	}
	static void dfs(int cnt) {
		if(cnt==m) {
			for(int num : arr) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			check[i] = true;
			arr[cnt] = i+1;
			dfs(cnt+1);
			check[i] = false;
		}
	}

}