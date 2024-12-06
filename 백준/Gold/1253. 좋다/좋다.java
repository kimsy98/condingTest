import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int answer = 0;
	static boolean[] vis;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		vis = new boolean[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			int l = 0;
			int r = n-1;
			while(true) {
				if(l==i||r==i) {
					if(l==i) l++;
					else r--;
				}
				
				if(l>=r)break;
				
				if(arr[l]+arr[r]==num) {
					answer++;
					break;
				}//합이 더 작은 경우
				else if(arr[l]+arr[r]<num) {
					l++;
				}//합이 더 큰 경우
				else {
					r--;
				}
				
				
			}
		}
		System.out.println(answer);
	}

}