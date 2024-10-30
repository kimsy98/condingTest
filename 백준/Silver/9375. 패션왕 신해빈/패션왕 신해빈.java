import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		
		for(int tc = 0; tc<testCase ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> hash = new HashMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				hash.put(type, hash.getOrDefault(type, 0)+1);
				
			}
			int res = 1;
			for(int num : hash.values()) {
				res*=(num+1);
			}
			System.out.println(res-1);
			
		}
		
	}

}