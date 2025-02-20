import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class Main {
	static int n,m,k;
//	static int[] set;
	static int[] frPay;
	static List<Integer>[] rela;
	static boolean[] vis;
	static List<List<Integer>> liSet;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		vis = new boolean[n+1];
//		set = IntStream.range(0, n+1).toArray();
		
		//친구비용
		frPay = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n;i++) {
			frPay[i] = Integer.parseInt(st.nextToken());
		}
		
		//관계
		rela = new ArrayList[n+1];
		for(int i =0; i<=n; i++) rela[i] = new ArrayList<>();
				
		for(int i =0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			rela[v].add(w);
			rela[w].add(v);
		}
		liSet = new ArrayList<>();
		for(int i =1; i<=n;i++) {
			if(vis[i])continue;
			List<Integer> li  =new ArrayList<>();
			li.add(i);
			liSet.add(li);
			dfs(i);
			
		}
		int answer = 0;
		for(List<Integer> li : liSet) {
			int min = 100000;
			for(int num : li) {
				min = Math.min(min, frPay[num]);
			}
			answer +=min;
		}
		if(answer>k) {
			System.out.println("Oh no");
			return;
		}
		System.out.println(answer);
//		System.out.println(Arrays.toString(set));
//		for(List<Integer> li : liSet) System.out.println(li);
	}
	static void dfs(int idx) {
		for(int i =0; i<rela[idx].size();i++) {
			if(vis[rela[idx].get(i)])continue;
			vis[rela[idx].get(i)] = true;
			liSet.get(liSet.size()-1).add(rela[idx].get(i));
			dfs(rela[idx].get(i));
		}
	}

}