import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			if(map.putIfAbsent(number, 1)!=null) map.put(number, map.get(number)+1);
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				sb.append(map.get(num)+" ");	
			}else {
				sb.append(0+" ");		
			}
		}
		System.out.println(sb);
	}

}