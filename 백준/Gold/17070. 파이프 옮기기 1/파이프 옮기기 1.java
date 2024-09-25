import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int arr[][];
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,1, 0);
		System.out.println(cnt);
		

	}
	private static void dfs(int row, int col, int dir) {
//		if(arr[row][col]==1)return;
		if(row==N-1&&col==N-1){
			cnt++;
			return;
		}
		switch(dir) {
		
		//0 : 가로 일 때 경우의 수 2가지
		case 0:
			if(col+1<N&&arr[row][col+1]!=1) {// 오른쪽으로 진행
				dfs(row, col+1, 0);
			}
			if (col + 1 < N && row + 1 <N && arr[row][col + 1] != 1 && arr[row + 1][col] != 1 && arr[row + 1][col + 1] != 1) {
	            dfs(row + 1, col + 1, 2);
	        }
			
			break;
		//1 : 세로 일 때 경우의 수 2가지
		case 1:
			if(row+1<N&&arr[row+1][col]!=1) {//아래쪽으로 진행
				dfs(row+1, col, 1);
			}
			if (col + 1 < N && row + 1 <N && arr[row][col + 1] != 1 && arr[row + 1][col] != 1 && arr[row + 1][col + 1] != 1) {
	            dfs(row + 1, col + 1, 2);
	        }
			break;

		//2 : 대각선 일 때 경우의 수 3가지
		case 2:
			if(col+1<N&&arr[row][col+1]!=1) {//오른쪽으로 진행
				dfs(row, col+1, 0);
			}
			if(row+1<N&&arr[row+1][col]!=1) {//아래쪽으로 진행
				dfs(row+1, col, 1);
			}
			if (col + 1 < N && row + 1 <N && arr[row][col + 1] != 1 && arr[row + 1][col] != 1 && arr[row + 1][col + 1] != 1) {
	            dfs(row + 1, col + 1, 2);
	        }
			break;

			
		}	
		
	}

}