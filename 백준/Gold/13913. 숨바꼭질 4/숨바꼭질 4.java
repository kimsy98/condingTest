import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int n;
	static int k;
	static int[] vis;
	static int[] parent;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		vis = new int[100001];
		Arrays.fill(vis, -1);
		parent = new int[100001];
		
		
		if(n==k) {
			System.out.println(0);
			System.out.println(n);
			System.exit(0);
		}
		bfs(n,k);
		System.out.println(vis[k]);
		
		Stack<Integer> s = new Stack<Integer>();
		while(k!=n) {
			s.push(k);
			k = parent[k];
		}
		s.push(n);
		
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
		
	}

	static void bfs(int st, int end) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(st);
		vis[st] = 0;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			if(num +1 <=100000&&vis[num+1]==-1) {
				vis[num+1] = vis[num]+1;
				parent[num+1] = num;
				q.add(num+1);
			}
			
			if(num -1 >=0&&vis[num-1]==-1) {
				vis[num-1] = vis[num]+1;
				parent[num-1] = num;
				q.add(num-1);
			}
			
			if(num *2 <=100000&&vis[num*2]==-1) {
				vis[num*2] = vis[num]+1;
				parent[num*2] = num;
				q.add(num*2);
			}
			
			
			if(vis[end]!=-1)return;
			
		}

		
		
	}

}