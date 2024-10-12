import java.util.Scanner;

public class Main {

	static int n,m;
	static int res[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		res = new int[m];
		permu_repe(0);
		
		System.out.println(sb);
	}
	static void permu_repe(int dep) {
		if(dep==m) {
			for(int num:res) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <=n; i++) {
			res[dep] = i;
			permu_repe(dep+1);
		}
	}

}