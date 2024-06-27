
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r,c,k;
	static char[][] arr;
	static boolean[][] check;
	static int cnt = 0;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		check = new boolean[r][c];
		
		for (int i = 0; i < r; i++) {
			char[] charlist = br.readLine().toCharArray();
			for(int j =0;j<c;j++) {
				arr[i][j] = charlist[j];
			}
		}

		check[r-1][0]=true;
		dfs(r-1,0,1);
		
		System.out.println(cnt);
	}
	public static void dfs(int row,int col, int count) {
		if(count==k) {
			if(row==0&&col==c-1) {
				cnt++;
				return;
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(nr<0||nr>=r||nc<0|nc>=c)continue;
			if(arr[nr][nc]=='T'||check[nr][nc])continue;
			
			
			check[nr][nc]=true;
			dfs(nr,nc,count+1);
			check[nr][nc]=false;
		}
	}

}