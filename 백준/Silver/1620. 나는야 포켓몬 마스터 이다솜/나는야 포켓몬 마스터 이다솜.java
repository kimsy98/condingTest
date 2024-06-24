import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<Integer,String> hashMap = new HashMap<>();
		Map<String,Integer> hashMapStr = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			hashMap.put(i, name);
			hashMapStr.put(name,i);
		}
		
		for (int i = 0; i < m; i++) {
			String poke = br.readLine();
			if(49<=poke.charAt(0)&&poke.charAt(0)<=57) {
				System.out.println(hashMap.get(Integer.parseInt(poke)));
			}else {
				System.out.println(hashMapStr.get(poke));
			}
		}
	}

}