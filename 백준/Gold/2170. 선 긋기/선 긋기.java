import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] line = new int[n][2];
		int answer = 0;
		
		for(int i =0; i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[i][0] = a;
			line[i][1] = b;
			
		}
		Arrays.sort(line, (o1,o2)->o1[0]-o2[0]);
		int min = line[0][0];
		int max = line[0][1];
		for(int[] len : line) {
			if(len[0]<=max) {
				max = Math.max(max,len[1]);
			}else {
				answer+= Math.abs(max-min);
				min = len[0];
				max = len[1];
			}
		}
		answer+= Math.abs(max-min);
		System.out.println(answer);
		
	}

}