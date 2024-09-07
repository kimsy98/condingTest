import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	static Edge[] edgeList;
	static int[] parents;
	static int V, E;

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {

			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();

			edgeList[i] = new Edge(from, to, weight);
		}

		long cost = getMST();
		sb.append(cost).append('\n');

		System.out.println(sb);
	}

	private static long getMST() {

		makeSet();// 단위 서로소 집합

		// 간선리스트 오름차순 정렬
		Arrays.sort(edgeList);

		long count = 0;
		int cnt = 0;
		for (Edge edge : edgeList) {
			int from = edge.from;
			int to = edge.to;
			int weight = edge.weight;

			if (union(from, to)) {
				cnt++;
				count += weight;
				if (cnt == V - 1)
					break;// 간선 연결 다함
			}

		}

		return count;
	}

	private static boolean union(int a, int b) {
		int RootA = find(a);
		int RootB = find(b);

		if (RootA == RootB)
			return false;

		parents[RootB] = RootA;
		return true;

	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	private static void makeSet() {
		parents = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parents[i] = i;
		}

	}
}