import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n,m;
	static int[] arr;
	static boolean[] visit;
	static int[] res;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		visit = new boolean[n];
		arr = new int[n];
		res = new int[m];
		
		
		for(int i =0 ; i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		permu(0);
		System.out.println(sb);
	}
	static void permu(int dep) {
		if(dep==m) {
			for(int num : res) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i =0; i<n; i++) {
			if(visit[i])continue;
			visit[i] = true;
			res[dep] = arr[i];
			permu(dep+1);
			visit[i] = false;
		}
	}

}