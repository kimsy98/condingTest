import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11404 {
	
	static final int INF = 9999999;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		StringTokenizer st;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] =INF;
				
				if(i==j)arr[i][j] = 0;
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a-1][b-1] = Math.min(arr[a-1][b-1], c);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(arr[i][k]+arr[k][j]<arr[i][j]) arr[i][j] = arr[i][k]+arr[k][j];
				}
			}
			
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]==INF)arr[i][j] = 0;
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
