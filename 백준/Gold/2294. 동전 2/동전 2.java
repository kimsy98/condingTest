import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] coins;
	static int[] kArr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		

		kArr = new int[k+1];
		coins = new int[n];

		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			coins[i] = coin;
		}
		Arrays.fill(kArr, 100000);
		kArr[0] = 0;
		
		for(int i =0; i<n; i++) {
			for(int j = coins[i]; j<=k; j++) {
				kArr[j] = Math.min(kArr[j], kArr[j-coins[i]]+1);
			}
		}
		
		System.out.println((kArr[k]==100000) ? -1 : kArr[k]);
	}


}