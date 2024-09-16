import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> res = new LinkedList<>();
		int N,K;
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i =0;i<N;i++) {
			que.offer(i+1);
		}
		
		int cnt = 0;
		while(!que.isEmpty()) {
			
			if(cnt==K-1) {
				res.offer(que.poll());
				
			}
			else {
				que.offer(que.poll());
			}
			cnt++;
			if(cnt==K) {
				cnt = 0;
			}
		}
		
		System.out.print("<");
		while(!res.isEmpty()) {
			if(res.size()==1) {
				
				System.out.print(res.poll());
			}
			else {
				System.out.print(res.poll()+", ");

			}
		}
		System.out.print(">");
		System.out.println();

	}

}