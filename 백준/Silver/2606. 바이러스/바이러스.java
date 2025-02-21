import java.util.*;
import java.io.*;
public class Main {
	static int n, pair;
	static int[][] arr;
	static boolean[] visit;
	static int answer =0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		
		visit = new boolean[n+1];
		arr = new int[n+1][n+1];
		
		for(int i =0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[start][end] = 1;
			arr[end][start] = 1;
		}
		visit[1]  = true;
		dfs(1);
		System.out.println(answer);
	}
	static void dfs(int start) {
		
		for(int i =1; i<arr[start].length; i++) {
			if(visit[i])continue;
			if(arr[start][i]==0) continue;
			visit[i] = true;
			answer++;
			dfs(i);
		}
	}

}