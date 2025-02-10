import java.util.*;
import java.io.*;
public class Main {
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n;
		int k;
		n = sc.nextInt();
		k = sc.nextInt();
	
		bfs(n,k);
		System.out.println(ans);
	}

	static void bfs(int n , int k) {
		boolean[] vis = new boolean[100001];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n,0});
		vis[n] = true;
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			if(arr[0]==k) {
				ans = Math.min(ans, arr[1]);
			}
			
			if(arr[0]*2<=100000&&!vis[arr[0]*2]) {
				q.add(new int[] {arr[0]*2,arr[1]});
				vis[arr[0]*2] = true;
			}
			
			if(arr[0]-1>=0&&!vis[arr[0]-1]) {
				q.add(new int[] {arr[0]-1,arr[1]+1});
				vis[arr[0]-1] = true;
			}
			
			if(arr[0]+1<=100000&&!vis[arr[0]+1]) {
				q.add(new int[] {arr[0]+1,arr[1]+1});
				vis[arr[0]+1] = true;
			}
			
			
			
		}
	}
}