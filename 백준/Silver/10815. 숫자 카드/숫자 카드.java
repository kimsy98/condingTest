import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] narr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			narr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(narr);
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		int[] marr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int l = 0;
			int r = n-1;
			boolean check = false;
			while(l<=r) {
				int mid  = (l+r)/2;
				int midV = narr[mid];				
				if(num>midV) {
					l = mid+1;
				}else if(num<midV){
					r = mid-1;
				}else{
					check = true;
					sb.append(1+" ");
					break;
				}
			}
			if(!check) sb.append(0+" ");
			
		}		
		System.out.println(sb);
		
		
		
	}

}