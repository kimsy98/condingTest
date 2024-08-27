import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[] parent;
	static int[] ans;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		parent = new int[n+1];
		
		for(int i=0; i<n+1;i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<n+1;j++) {
				int v = Integer.parseInt(st.nextToken());
				
//				if(i==j) continue;
				if(v==1) {
					union(i,j);

				}
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		ans = new int[m+1];
		
		//m 계획 수 돌면서 확인
		for(int i=1;i<m+1;i++) {
			int x = Integer.parseInt(st.nextToken());
			ans[i] = find(x);

		}
		int cnt = 0;
		ans[0] = ans[1];
		for(int i=1;i<m+1;i++) {
			if(ans[0]==ans[i])cnt++;
		}
		if(cnt == m) {
			System.out.println("YES");
		}else System.out.println("NO");
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}

}
