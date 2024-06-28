import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dice= {0, 0, 0, 0, 0, 0};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		int x= Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		int k= Integer.parseInt(st.nextToken());
		
		
		int[][] arr = new int[n][m];
		
		//0:동, 1:서, 3:븍, 4:남
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int dir = Integer.parseInt(st.nextToken())-1;
			int tempX = x+dx[dir];
			int tempY = y+dy[dir];
			if(tempX<0||tempX>=n||tempY<0||tempY>=m)continue;
			x += dx[dir];
			y += dy[dir];
			
			switch (dir) {
			case 0:
				move_right();
				break;

			case 1:
				move_left();
				break;

			case 2:
				move_up();
				break;
			case 3:
				move_down();
				break;
			}

			if(arr[x][y]==0) {
				arr[x][y] = dice[1];
			}
			else {
				dice[1] = arr[x][y];
				arr[x][y] = 0;
			}
			
		
			System.out.println(dice[0]);
		}
		
	}

	public static void move_right() {
		// 윗 -> 오 -> 바닥 -> 왼 -> 윗
		int temp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = temp;
		
	}
	
	public static void move_left() {
		// 윗 -> 왼 -> 바 -> 오 -> 윗
		int temp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = temp;
		
	}
	
	public static void move_up() {
		// 윗 -> 뒷 -> 바 -> 앞 -> 윗
		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = temp;
		
	}
	
	public static void move_down() {
		// 윗 -> 앞 -> 바 -> 뒷 -> 윗
		int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = temp;
		
	}



}