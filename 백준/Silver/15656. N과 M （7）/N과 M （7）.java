import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	
	static int[] arr;
	static int[] res;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		check = new boolean[n];
		res = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(n,m,0);
		System.out.println(sb);
	}
	public static void dfs(int N , int M, int cnt) {
		if(cnt==M) {
			for (int i : res) {
				sb.append(i+" ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			check[i] = true;
			res[cnt] = arr[i];
			dfs(N, M, cnt+1);
			check[i] = false;
		}
	}

}