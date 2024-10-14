import java.util.Scanner;

public class Main {

	static int n,m;
	static int[] res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		res = new int[m];
		
		permu(0,1);
		System.out.println(sb);
	}
	static void permu(int dep, int at) {
		if(dep==m) {
			for(int num : res) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = at; i <= n; i++) {
			res[dep] = i;
			permu(dep+1,i);
		}
	}

}