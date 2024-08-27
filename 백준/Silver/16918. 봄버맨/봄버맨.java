import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, N;
	static char[][] map;
	static char[][] copymap;
	static int nowTime;
	static Queue<Node> q = new ArrayDeque<>();
	static List<Node> boom = new ArrayList();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb =new StringBuilder();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		copymap = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			char arr[] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = arr[j];
				copymap[i][j] = 'O';
				if(map[i][j]=='O')boom.add(new Node(i,j));
				
			}
		}

		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
			return;
		}
//
//		if (N % 4 == 3) {
//			for (int i = 0; i < R; i++) {
//
//				for (int j = 0; j < C; j++) {
//					if (map[i][j] == 'O')
//						q.offer(new Node(i, j));
//				}
//			}
//
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					map[i][j] = 'O';
//				}
//			}
//			while (!q.isEmpty()) {
//				Node node = q.poll();
//				int x = node.x;
//				int y = node.y;
//				map[x][y] = '.';
//				for (int i = 0; i < 4; i++) {
//					int nr = x + dx[i];
//					int nc = y + dy[i];
//					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
//						continue;
//					map[nr][nc] = '.';
//				}
//
//			}
//
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//
//			System.exit(0);
//		}
//
//		if (N == 1) {
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.exit(0);
//		}
//
//		if (N%4==1) {
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.exit(0);
//		}
//		
		
//		for (int i = 0; i < R; i++) {
//			
//			for (int j = 0; j < C; j++) {
//				if(map[i][j]=='O')q.offer(new Node(i,j));
//			}
//		}
		nowTime++;
		
		
		while(true) {
			if(nowTime==N)break;

			//폭탄 다 넣기 2초
			for (int i = 0; i < R; i++) {
				
				map[i] = copymap[i].clone();
			}
			
			
			
			nowTime++;
			if(nowTime==N)break;
			for(Node boom : boom) {
				q.add(boom);
				map[boom.x][boom.y] = '.'; 
			}

			
			int qsize = q.size();
			while(qsize-->0) {
				Node node = q.poll();
				int x = node.x;
				int y = node.y;
				map[x][y] = '.';
				for (int i = 0; i < 4; i++) {
					int nr = x+ dx[i];
					int nc = y+ dy[i];
					if(nr<0||nr>=R||nc<0||nc>=C||map[nr][nc]=='.')continue;
					map[nr][nc]='.';
				}
				

				
			}
			boom.clear();
			
			
			for (int i = 0; i < R; i++) {
				
				for (int j = 0; j < C; j++) {
					if(map[i][j]=='O')boom.add(new Node(i,j));
				}
			}
			
			
			
			nowTime++;
			if(nowTime==N)break;
			
		}
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j <C; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		

	}

}
