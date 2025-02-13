import java.util.*;
import java.io.*;
public class Main {
	static int[] calender = {0,31,59,90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		List<int[]> fl = new ArrayList<>();
		
		
		for(int i =0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			int stm = Integer.parseInt(st.nextToken());
			int std = Integer.parseInt(st.nextToken());
			int em = Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken());
			int stNum = stm*100+std;
			int edNum = em*100+ed;
			fl.add(new int[] {stNum, edNum});
			
		}
		Collections.sort(fl,(o1,o2)->{
			if(o1[0]-o2[0]==0)return o2[1]-o1[1];
			return o1[0]-o2[0];
		});
//		for(int [] a : fl) {
//			System.out.println(Arrays.toString(a));			
//		}

		
		int start = 301;
		int end = 1201;
		int max = 0;
		int answer = 0;
		int idx =0;
		while(start<end) {
			boolean check= false;
			for(int i=0; i<n; i++) {
				if(fl.get(i)[0]> start) break;
				
				if(fl.get(i)[1]>max) {
					max = fl.get(i)[1];
					check = true;
//					idx = i+1;
				}
				
			}
			if(check) {
				start = max;	
				answer++;
			}else break;
			
		}
		
		if(max>=end)System.out.println(answer);
		else System.out.println(0);
		
		
	}


}