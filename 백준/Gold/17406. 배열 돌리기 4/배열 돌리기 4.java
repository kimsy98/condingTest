import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class rcs{
		int r, c,s;

		public rcs(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
		
		
	}
	static int N,M,K;
	static int board[][];
	static int spinboard[][];
	static boolean[] isSelected;
	static rcs[] RCS;
	static rcs result[];
	static int total = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][M+1];
		spinboard = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int i = 0; i < board.length; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		
		RCS = new rcs[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			RCS[i] = new rcs(r,c,s);
		}
		isSelected = new boolean[K];
		result = new rcs[K];
		permu(0);
		
		System.out.println(total);
	}
	private static void permu(int cnt) {
		
		if(cnt == K) {
			spin();
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(isSelected[i])continue;
			isSelected[i]=true;
			result[cnt] = RCS[i];
			permu(cnt+1);
			isSelected[i] = false;
		}		
		
	}
	private static void spin() {
		int[][] boardcp = new int[N+1][M+1];
		for (int j = 0; j < board.length; j++) {
			boardcp[j] = board[j].clone();
		}

		for (int i = 0; i <K; i++) {

			int r = result[i].r;
			int c = result[i].c;
			int s = result[i].s;
			
			for (int j = 0; j < boardcp.length; j++) {
				spinboard[j] = boardcp[j].clone();
			}
			
			int strow = r-s;
			int stcol = c-s;
			int endrow = r+s;
			int endcol = c+s;
			int n =0;
			while(true) {
				for(int col = stcol+n+1;col<=endcol-n;col++) {//오른쪽으로 이동
					spinboard[strow+n][col] = boardcp[strow+n][col-1];
				}
				for(int row = strow+n+1;row<=endrow-n;row++) {//아래 이동
					spinboard[row][endcol-n] = boardcp[row-1][endcol-n];
				}
				for(int col = endcol-n-1;col>=stcol+n;col--) {//왼쪽으로 이동
					spinboard[endrow-n][col] = boardcp[endrow-n][col+1];
				}
				for(int row = endrow-n-1;row>=strow+n;row--) {//위쪽으로 이동
					spinboard[row][stcol+n] = boardcp[row+1][stcol+n];
				}
				if((endrow+strow)%2==0&&(endcol+stcol)%2==0) {
					
					int x = (endrow+strow)/2;
					int y = (endcol+stcol)/2;
					spinboard[x][y] = boardcp[x][y];
				}
				
				for (int j = 0; j < spinboard.length; j++) {
					boardcp[j] = spinboard[j].clone();
				}
				
				n++;
				if((endcol-stcol)/2==n)break;
				
			}
			
			


			
			
		}
//		total = Integer.MAX_VALUE;
		int sum =0;
		for (int j = 1; j <spinboard.length; j++) {
			for (int i = 0; i <spinboard[j].length; i++) {
				sum +=spinboard[j][i];
			}
			if(sum<total)total = sum;
			sum = 0;
		}
		

		
		
	}

}