import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	static int n,m;
	static int[] set;
	static int T;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		set = IntStream.range(0, n+1).toArray();
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		if(T!=0) {
			while(st.hasMoreTokens()) {
				int i = Integer.parseInt(st.nextToken());
				set[i] = 0;
			}
		}
		int MemberCnt = 0;
		List<Integer>[] party = new ArrayList[m];
		for(int i =0; i< m ; i++) party[i] = new ArrayList<>();
		List<Integer>[] memberSet = new ArrayList[n+1];
		for(int i =0; i<=n ; i++) memberSet[i] = new ArrayList<>();
		
		
		for(int i =0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			MemberCnt = Integer.parseInt(st.nextToken());
			boolean check = false;
			for(int j =0; j<MemberCnt ; j++) {
				int member = Integer.parseInt(st.nextToken());
				party[i].add(member);
			}
			for(int k = 0; k<MemberCnt;k++) {
				for(int l = 0; l<MemberCnt;l++) {
					if(k==l)continue;
					memberSet[party[i].get(k)].add(party[i].get(l));
				}
			}

		}
		
		for(int i =1; i<=n;i++) {
			if(set[i]==0) dfs(i,memberSet);
		}
		
		
		int answer =0 ;
		for(List<Integer> li : party) {
			boolean check = false;
			for(int num : li) {
				if(set[num]==0) check = true;
			}
			if(!check)answer++;
		}
		System.out.println(answer);
//		System.out.println(Arrays.deepToString(party));
//		System.out.println(Arrays.deepToString(memberSet));
//		System.out.println(Arrays.toString(set));
	}
	private static void dfs(int start, List<Integer>[] memberSet) {
		
		for(int i =0; i<memberSet[start].size();i++) {
			if(set[memberSet[start].get(i)]== 0)continue;
			set[memberSet[start].get(i)]= 0;
			dfs(memberSet[start].get(i), memberSet);
		}
	}
}