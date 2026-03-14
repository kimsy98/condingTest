import java.util.*;
import java.io.*;

public class Main {
/**
 * @param args
 * @throws IOException
 */
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i =0; i<N;i++) {
        	set.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< M; i++) {
        	if(set.contains(Integer.parseInt(st.nextToken()))){
        		sb.append(1).append('\n');
        	}else sb.append(0).append('\n');
        }
        System.out.println(sb.toString());
        		
	}

}