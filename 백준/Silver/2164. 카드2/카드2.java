
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N;
		int result = 0;
		N = sc.nextInt();

		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			que.offer(i);
		}

		while (!que.isEmpty()) {

			result = que.poll();
			
			if(!que.isEmpty()) {
				que.offer(que.poll());
			}

//			if (que.size() == 1) {
//				result = que.poll();
//			}
		}

		System.out.println(result);

	}

}