import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int max = 100000;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr =  new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = max;
				if(i==j) arr[i][j] = 0;
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start  = Integer.parseInt(st.nextToken());
			int end  = Integer.parseInt(st.nextToken());
			
			arr[start][end] = arr[end][start] = 1;
		}
		
		for (int k = 1; k <=n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <=n; j++) {
					if(arr[i][j] > arr[i][k]+arr[k][j]) {
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
		
		int res = max;
		int idx = 0;
		
		for (int i = 1; i <=n; i++) {
			int total = 0;
			for (int j = 1; j <=n; j++) {
				total+=arr[i][j]; 
			}
			if(res>total) {
				res = total;
				idx = i;
			}
		}
		System.out.println(idx);
		
	}

}