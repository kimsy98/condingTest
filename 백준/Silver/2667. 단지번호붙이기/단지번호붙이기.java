
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * n*n 지도의 정보 1대륙0바다 붙어있음 대륙에 번호 붙이기 덩어리 별로 붙이기
	 * 
	 * 번호 붙은 지도 출력 
	 * 대륙 개수 
	 * 대륙 크기 출력
	 * 
	 * N 대륙정보를 스페이스바 없이
	 * 
	 */

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int N;
	static int board[][];
	static int vis[][];
	static Queue<Point> que = new LinkedList<Point>();
	static int drc[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int cnt;
	static int size;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> li = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		vis = new int[N][N];

		for (int i = 0; i < board.length; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), "");
			char arr[] = br.readLine().toCharArray();
			for (int j = 0; j < board.length; j++) {
				board[i][j] = arr[j]-'0';
//				System.out.println(board[i][j]);
			}
			
//			for (int j = 0; j < board.length; j++) {
//				board[i][j] = Integer.parseInt(st.nextToken());
//				
//			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 1 && vis[i][j] == 0) {
					vis[i][j] = 1;
					board[i][j] = ++cnt;
					que.offer(new Point(i, j));
					dfs();
				}
			}
		}

		System.out.println(cnt);
		li.sort(null);
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
		
	}

	private static void dfs() {
		// TODO Auto-generated method stub
		size=0;
		while (!que.isEmpty()) {
			size++;
			Point now = que.poll();
			for (int i = 0; i < drc.length; i++) {
				int nr = now.r + drc[i][0], nc = now.c + drc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (board[nr][nc] == 1 && vis[nr][nc] == 0) {
					vis[nr][nc] = 1;
					board[nr][nc] = cnt;
					que.offer(new Point(nr, nc));
				}
			}

		}
		li.add(size);
	}

}
