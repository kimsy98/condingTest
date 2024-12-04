import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n;
	static Dir[] dir;
	static class Dir{
		int X;
		String C;
		Dir(int X, String C){
			this.X = X;
			this.C = C;
		}
	}
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		int k = Integer.parseInt(br.readLine());

		for(int i =0 ; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = 1;
			
		}
		int l =  Integer.parseInt(br.readLine());
		dir = new Dir[l];
		for(int i =0 ; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			dir[i] = new Dir(x,c);
		}
		
		game(0);
		/***
		 * 0.시작은 1초부터 
		 * 1.time 증가
		 * 2.dir 방향으로 이동 move()
		 * 3.n*n범위 밖이거나 몸에 닿으면 종룔 check()
		 * 4.사과가 있다면 먹고 없앤뒤 꼬리 이동 멈추고 사과 자리를 몸에 추가 appleCheck() == true 면=> snake.add(현재 위치) 
		 * 5.사과 없으면 꼬리 이동 즉, 몸길이 변화 없음 appleCheck()  == false 면=> snake.remove(꼬리) snake.add(현재 위치) 
		 * 주의점 방향 전환은 다음초에 반영 예) 3 D 면 4초부터 오른쪽 회전 후 직진
		 */
	}
	static class Position{
		int r,c;
		Position(int r, int c){
			this.r = r;
			this.c = c;
		}
		void setPosition(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static void game(int time) {
		//뱀몸통
		Deque<Position> pos = new ArrayDeque<>();
		//뱀머리
		Position snakeHead = new Position(0, 0);
//		Position snakeTail = null;
		//방향 우 0 하 1 좌 2 상 3
		int direction = 0;
		
		while(true) {
			time ++;
			int prevSr = snakeHead.r;
			int prevSc = snakeHead.c;
			
			//move
			snakeHead.setPosition(dx[direction]+prevSr,dy[direction]+prevSc);
		
			//check
			int sr = snakeHead.r;
			int sc = snakeHead.c;
			//범위 밖이거나
			if(sr<0||sr>=n||sc<0||sc>=n){
				answer = time;
				break;
			}
			//몸통에 닿았거나
			for(Position p : pos) {
				if(sr==p.r&&sc==p.c){
					answer = time;
					break;	
				}
			}
//			pos.contains(snakeHead);
			
			if(answer==time)break;
			
			//appleCheck()
			if(board[sr][sc]==1) {
				board[sr][sc] = 0;
				//이전 머리 위치가 몸통이 됨 큐 앞에 넣기
				pos.addFirst(new Position(prevSr,prevSc));
			}//사과 없을때
			else {
				//몸통이 1이상이면  이전 머리 위치 앞에 넣고 뒤에 꼬리 빼고
				if(!pos.isEmpty()) {
					pos.addFirst(new Position(prevSr,prevSc));
					pos.pollLast();
				}
			}
			
			//방향전환
			for(Dir di : dir) {
				if(time==di.X) {
					if(di.C.equals("D")) {
						direction = (direction+1)%4;
					}else {
						direction = (direction+3)%4;						
					}
				}
			}
			
		}
		System.out.println(answer);
		
	}

}