import java.util.*;
import java.io.*;

public class Main {
/**
 * 1. ( 만 존재 하는 경우 NO
 * 2. ) 만 존재 하는 경우 NO
 * 3. 다 돌았는데 stack 에 존재하는 경우 NO
 * 4. 돌다가 stack이 없는 경우 NO
 * 5. 그 외 경우는 YES
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<tc; i++){
            Stack<Character> stack = new Stack<>();
        	st = new StringTokenizer(br.readLine());
            String VPS = st.nextToken();
            boolean check = true;
            for(int j = 0; j<VPS.length();j++) {
            	if(VPS.charAt(j)=='(') {
            		stack.add(VPS.charAt(j));
            	}else{
            		if(!stack.isEmpty()) {
            			stack.pop();
            		}else {
            			check = false;
            			break;
            		}
            	}
            	
            }
        	if(stack.isEmpty()&&check) sb.append("YES").append('\n');
        	else sb.append("NO").append('\n');
        	
        }
        System.out.println(sb.toString());
		
	}

}