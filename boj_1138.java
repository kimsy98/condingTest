import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1138 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> result = new ArrayList<>();
		int[] height = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i <n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = n-1; i >= 0; i--) {
			result.add(height[i],i+1);
		}
		for (int i : result) {
			System.out.print(i+" ");
			
		}

	}

}


