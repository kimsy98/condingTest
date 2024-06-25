import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class count{
		long a;
		int cnt;
		public count(long a,int cnt) {
			this.a = a;
			this.cnt = cnt;
		}
	}
	static long a, b;
	public static void main(String[] args) {
		
		Scanner sc  = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		
		int res = bfs(a,0);
		System.out.println(res);
	}
	static int bfs(long A,int cnt) {
		Queue<count> q = new LinkedList<>();
		q.add(new count(A,cnt));
		
		while(!q.isEmpty()) {
			count C = q.poll();
			long multi = C.a*2;
			long rightOne = C.a*10+1;
			if(multi==b) return C.cnt+2;
			if(rightOne==b) return C.cnt+2;
			if(multi>b&&rightOne>b)continue;
			q.add(new count(multi,C.cnt+1));
			q.add(new count(rightOne,C.cnt+1));
		}
		
		
		return -1;
	}

}