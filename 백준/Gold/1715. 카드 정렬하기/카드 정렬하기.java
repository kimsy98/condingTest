import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int n;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=0; i<n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		if(pq.size()==1) {
			answer = 0;
			System.out.println(answer);
			return;
		}
		while(!pq.isEmpty()) {
			int a = pq.poll();
			if(pq.peek() == null)break;
			int b = pq.poll();
			int next = a+b;
			answer+=next;
			pq.add(next);
		}
		System.out.println(answer);
	}

}