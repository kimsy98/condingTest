import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

//	static class Point {
//		int r, c;
//
//		public Point(int r, int c) {
//			super();
//			this.r = r;
//			this.c = c;
//		}
//	}

	static int n;
	static int m;
	static int[][] board;
//	static int[] chickenmin;
	static int house;
	static int result = Integer.MAX_VALUE;
	static int[][] po ;
	static List<int[]> chi = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		po = new int[m][2];
		board = new int[n][n];
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2)
					chi.add(new int[]{i,j});
//				if(board[i][j]==1) house++;
			}
		}
//		System.out.println(chi.get(0)[]);
//		for (int i = 0; i < chi.size(); i++) {
//			int[] p = chi.get(i);
//			System.out.println(p[0] + " " + p[1]);
//		}
//		chickenmin = new int [house];
//		for (int i = 0; i < chi.size(); i++) {
//			chickenmin[i] = Integer.MAX_VALUE; 
//		}

		combi(0, 0);
		System.out.println(result);
	}

//	int[] a =  chi.get(1po[0]);
//	a[0], a[1]
	private static void chickencheck() {
		int res = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1) {
					int min = Math.abs(po[0][0] - i) + Math.abs(po[0][1] - j);
					for (int j2 = 1; j2 < m; j2++) {
//						Point p = chi.get(j2);
//						int min  = Math.abs(po[k].r-i)+Math.abs(po[k].c-j);
						if (min >= Math.abs(po[j2][0] - i) + Math.abs(po[j2][1] - j)) {
							min = Math.abs(po[j2][0] - i) + Math.abs(po[j2][1] - j);
						}

					}
					res+=min;
				}
			}
		}
		if (res <= result)
			result = res;

	}

	private static void combi(int cnt, int start) {

		if (cnt == m) {
			chickencheck();
			return;
		}

		for (int i = start; i < chi.size(); i++) {
			int[] p = chi.get(i);
//			System.out.println(Arrays.toString(p));
			po[cnt][0] = p[0];
			po[cnt][1] = p[1];
			combi(cnt + 1, i + 1);
		}

	}

}