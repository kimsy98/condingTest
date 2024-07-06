import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int treeCnt;
	static List<List<Integer>> li;
	static boolean[] check;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if(n==0&&m==0)break;
			
			treeCnt = 0;
			check = new boolean[n];
			li = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				li.add(new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				li.get(start).add(end);
				li.get(end).add(start);
				
			}
			for (int i = 0; i < n; i++) {
				if(check[i])continue;
				check[i]=true;
				if(dfs(i,-1))treeCnt++;				
			}

			
			if(treeCnt==1)System.out.println("Case "+tc+": There is one tree.");
			else if(treeCnt==0)System.out.println("Case "+tc+": No trees.");
			else System.out.println("Case "+tc+": A forest of "+treeCnt+" trees.");
			 
			
			tc++;
		}
		
		
	}
	static boolean dfs(int idx, int root) {

		int size = li.get(idx).size();
		for (int i = 0; i < size; i++) {
			if(li.get(idx).get(i)==root)continue;
			if(check[li.get(idx).get(i)])return false;
			check[li.get(idx).get(i)] = true;
			if(!dfs(li.get(idx).get(i),idx)) return false;			
		
		}
		return true;
		
	}

}