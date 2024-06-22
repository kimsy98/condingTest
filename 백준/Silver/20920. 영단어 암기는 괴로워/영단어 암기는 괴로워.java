import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> wordMap  =new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			
			String word = br.readLine();
			if(word.length()<m)continue;
			wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
		}
//		List<String> words = wordMap.keySet().stream().collect(Collectors.toList());
		List<String> words = new ArrayList<>(wordMap.keySet());		
		
		words.sort((o1,o2)->{
			int c1 = wordMap.get(o1);
			int c2 = wordMap.get(o2);
			
			if(c1==c2) {
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}
				return o2.length()-o1.length();
			}
			return c2-c1;
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.size(); i++) {
			sb.append(words.get(i)+"\n");
			
		}
		System.out.println(sb);
	}

}