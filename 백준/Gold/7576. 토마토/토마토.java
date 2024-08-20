import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	static int M, N;
	static int[][] board;
	static int[][] visit;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int cnt;
	static Queue<Point> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1)
					visit[i][j] = 1;
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] == 1 && visit[i][j] == 0) {
					visit[i][j] = 1;
					que.offer(new Point(i, j));

				}

			}
		}
		bfs();
		int check=0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j]==0) {
					check = -1;
					break;
				}
			}
		}
		if(check==-1) {
			System.out.println(-1);
		}else System.out.println(cnt-1);
//		System.out.println(cnt-1);

	}

	private static void bfs() {
		while(!que.isEmpty()) {
//			for (int i = 0; i < board.length; i++) {
//				for (int j = 0; j < board[i].length; j++) {
//					if(board[i][j]==1) {
			int size = que.size();
			for (int j = 0; j < size; j++) {
				
				Point p = que.poll();
				
				for (int k = 0; k < 4; k++) {
					int nc = p.col + dc[k];
					int nr = p.row + dr[k];
					if(nc<0||nc>=M||nr<0||nr>=N)continue;
					if(visit[nr][nc]==0&&board[nr][nc]==0) {
						board[nr][nc]=1;
						visit[nr][nc]=1;
						que.offer(new Point(nr,nc));
//						for (int i = 0; i < board.length; i++) {
//							System.out.println(Arrays.toString(board[i]));
//						}
//						System.out.println();
					}
				}
			}
			cnt++;
//						bfs();
						
						
						
//					}
//				}
//			}
			
		}
		
	}

}