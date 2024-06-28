import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = n;
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			outerLoop:
			for (int j = 0; j < word.length()-1; j++) {
				if(word.charAt(j)!=word.charAt(j+1)) {
					for(int k =j+1; k<word.length();k++) {
						if(j+1==k) continue;
						if(word.charAt(j)==word.charAt(k)) {
							cnt--;
//							System.out.println(word);
//							System.out.println(j+","+k);
							break outerLoop;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}