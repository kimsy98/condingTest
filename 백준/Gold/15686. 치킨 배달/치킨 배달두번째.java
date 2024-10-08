import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15686 {

	static int n,m;
//	static int[][] arr;
	static ArrayList<int[]> house = new ArrayList<int[]>();
	static ArrayList<int[]> chicken = new ArrayList<int[]>();
	static ArrayList<int[]> selected = new ArrayList<int[]>();
	static boolean[] visited;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		

		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < n; j++) {
				int check = Integer.parseInt(st.nextToken());
				if(check==1) {
					house.add(new int[] {i,j});
				}else if(check==2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		visited = new boolean[chicken.size()];
		
		chickenRange(0,0);
		System.out.println(res);
		
		
	}
	static void chickenRange(int cnt, int start) {
		if(cnt==m) {
			int sum = 0;
			for(int[] h:house) {
				int min = Integer.MAX_VALUE;
				for(int[] ch:selected)  {
						int len = Math.abs(h[0]-ch[0])+Math.abs(h[1]-ch[1]);
						min = Math.min(min, len);
				}
				sum+=min;
			}
			res = Math.min(sum, res);
			return;
		}
		
		for (int i = start; i <chicken.size(); i++) {
			if(!visited[i]) {
				visited[i]= true;
				selected.add(chicken.get(i));
				chickenRange(cnt+1,i+1);
				selected.remove(selected.size()-1);
				visited[i] = false;
			}
		}
	}

}
