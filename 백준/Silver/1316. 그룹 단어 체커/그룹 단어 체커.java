import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		boolean check;
		for (int i = 0; i < n; i++) {
			check = true;
			String word = br.readLine();
			Stack<Character> st = new Stack<>();
			
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if(!st.contains(c)){
					st.add(c);
				}else {
					if(st.peek()==c) continue;
					else {
						check=false;
						break;
					}
				}
			}
			if(check==true) cnt++;
			
		}
		System.out.println(cnt);
	}

}