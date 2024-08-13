import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Score{
	int start, score;
	public Score(int start, int score){
		this.start = start;
		this.score = score;
	}
}
public class Main {
	static int n;
	static List<List<Integer>> li; 
	static int minScore=Integer.MAX_VALUE;
	static int num=0;
	static int scorearr[];
	static boolean[] visit;
	static int idx=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		li = new ArrayList<>();
		for (int i = 0; i <=n ; i++) {
			li.add(new ArrayList<>());
		}
		scorearr = new int[n+1];
		
		while(true){
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(start==-1&&end==-1)break;
			li.get(start).add(end);
			li.get(end).add(start);
			
		}
		StringBuilder sb= new StringBuilder();
		for (int i = 1; i <=n; i++) {
			bfs(i);
		}
		for (int i = 1; i <=n; i++) {
			if(minScore==scorearr[i]) {
				num++;
				sb.append(i+" ");
			}
			
		}
		System.out.println(minScore+" "+num);
		System.out.println(sb);
		
		
	}
	public static void bfs(int i) {
		visit = new boolean[n+1];
		Queue<Score> q = new LinkedList<>();
		visit[i] = true;
		q.add(new Score(i,0));

		while(!q.isEmpty()) {
			
			Score s = q.poll();
			int start = s.start;
			int score = s.score;
		
			if(scorearr[i]<score) scorearr[i] = score;
			for (int end: li.get(start)) {
				if(!visit[end]) {
					visit[end] = true;
					q.add(new Score(end, score+1));		
				}
			}
		}
		
		if(minScore>scorearr[i]) {
			minScore = scorearr[i];
		}
		
		
	}

}