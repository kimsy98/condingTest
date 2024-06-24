import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			String ex = st.nextToken();
			if(!map.containsKey(ex)) list.add(ex);
			map.put(ex,map.getOrDefault(ex,	0) +1 );
		}
		Collections.sort(list);
		for (String s : list) {
			System.out.println(s+" "+ map.get(s));
		}
	}

}