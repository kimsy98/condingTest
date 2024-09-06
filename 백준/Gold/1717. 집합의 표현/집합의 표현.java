import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		
		for(int i=0; i<n+1;i++) {
			parent[i] = i;
		}
		
		for(int i =0;i<m;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int cal = Integer.parseInt(st.nextToken());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(cal==0){
				union(a,b);
			}
			else if (cal==1){
				int x = find(a);
				int y =find(b);
				
				if(x==y) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
			}
		}
		
		System.out.println(sb);
		
		
	}
	
    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }
	static int find(int a) {
		
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
		
	}

}
