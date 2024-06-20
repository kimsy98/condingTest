import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		char[] arr = str.toCharArray();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if(arr[i]=='P') {
				int r = Math.max(i-k, 0);
				int e = Math.min(i+k, n-1);
				for (int j = r; j <=e ; j++) {
					if(arr[j]=='H') {
						cnt++;
						arr[j]='0';
						break;
					}
				}
			}
		}

		System.out.println(cnt);
		
	}

}