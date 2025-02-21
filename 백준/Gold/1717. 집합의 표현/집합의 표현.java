import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	static int n,m;
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = IntStream.range(0, n+1).toArray();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			if(oper==0) {
				union(a,b);
			}else {
				int x = find(a);
				int y = find(b);
//				check(x,y);
				if(x==y) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
				
			}
		}

		System.out.println(sb);
		
	}
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		
		if(x < y) {
			parent[y] = x;
		}else parent[x] = y;
	}
	static int find(int a) {
		
		if(parent[a]==a)return a;
		return parent[a] = find(parent[a]);
	}
	static void check(int x, int y) {
		if(x==y) {
			sb.append("YES").append("\n");
		}else {
			sb.append("No").append("\n");
		}
	}
	
}