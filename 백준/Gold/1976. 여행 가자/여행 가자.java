import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[] plan;
	static int[] parent;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		plan = new int[m];
		parent = new int[n+1];
		
		for(int i=0; i<n+1;i++) {
			parent[i] = i;
		}
		
		for(int i =1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <=n; j++) {
				int val = Integer.parseInt(st.nextToken());
				
				if(val==1) {
					union(i,j);
				}
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i =0; i<m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		
		parent[0] = parent[plan[0]];
		boolean check = true;
		
		for(int i =0; i<m;i++) 	{
			if(parent[plan[i]]!=parent[0]){
				check = false;
				break;
			}
		}
		System.out.println((check==true)? "YES": "NO");
		
	}
	static void union(int x, int y) {

		x = find(x);
		y = find(y);
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
		
	}
	static int find(int idx) {
		if(parent[idx]==idx) {
			return idx;
		}
		return parent[idx] = find(parent[idx]);
	}

}