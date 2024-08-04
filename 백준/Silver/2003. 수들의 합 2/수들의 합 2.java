import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n  = Integer.parseInt(st.nextToken());
		int m  = Integer.parseInt(st.nextToken());
	
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		arr[0] = 0;
		for (int i = 1; i < n+1; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		int start   = 1;
		int end =  1;
		int res=0;
		while(true) {
			if(arr[end]-arr[start-1]<m) {
				end++;
			}else if(arr[end]-arr[start-1]==m) {
				end++;
				res++;
			}else {
				start++;
			}
			
			if(end>=n+1)break;
		}
		
		System.out.println(res);
	}

}