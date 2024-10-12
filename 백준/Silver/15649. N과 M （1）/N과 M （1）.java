import java.util.Scanner;

public class Main {

	static int n,m;
	static boolean[] visit;
	static int[] arr;
	static int[] res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n+1];
		visit = new boolean[n+1];
		res = new int[m];
		
		for (int i = 0; i <=n; i++) {
			arr[i] = i;
		}
		
		permu(0);
		System.out.println(sb);
	}
	static void permu(int depth) {
		if(depth==m) {

			for (int i = 0; i <m; i++) {
					sb.append(res[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <=n; i++) {
			if(visit[i])continue;
			visit[i] = true;
			res[depth] = arr[i];
			permu(depth+1);
			visit[i] = false;
		}
	}

}