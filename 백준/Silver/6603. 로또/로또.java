import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] ans;
	static boolean[] vis;
	static int k;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k==0)break;
			
			arr = new int[k];
			ans = new int[6];
			for(int i=0; i<k;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			back(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	static void back(int st, int cnt) {
		if(cnt==6) {
			for(int num : ans) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=st ; i<k;i++) {
			ans[cnt] = arr[i];
			back(i+1, cnt+1);
		}
	}

}