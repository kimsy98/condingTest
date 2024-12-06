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
	static List<Integer> coins;
	static int[] kArr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		

		kArr = new int[k+1];
		coins = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			if(coin<=k) {
				coins.add(coin);
			}
		}
		Arrays.fill(kArr, 10001);
		solution();
		if(kArr[k]>=10001)kArr[k] = -1;
		System.out.println(kArr[k]);
	}
	static void solution() {
		for(int i =1; i<=k; i++) {
			int l =1;
			int r = i-1;
			
			for(int coin : coins) {
				if(i%coin==0) {
					kArr[i] = Math.min(kArr[i], i/coin);
				}
			}
			while(true) {
				if(l>=r)break;
				
				kArr[i] = Math.min(kArr[i], kArr[l]+kArr[r]);
				l++;
				r--;
			}
			
		}
	}

}