import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int l,c;
	static char[] arr;
	static char[] res;
	static char[] check = {'a','e','i','o','u'};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[c];
		res = new char[l];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			String ch = st.nextToken();
			arr[i] = ch.charAt(0);
		}
		
		Arrays.sort(arr);
		

		permu(0,0);
		System.out.println(sb);
	}
	static void permu(int dep,int st) {
		
		if(dep==l) {
			
			int vow = 0;
			int notVow=0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < res.length; j++) {
					if(check[i]==res[j])vow++;
				}
			}
			
			notVow = res.length-vow;
			if(vow>=1&&2<=notVow) {
				for(char ch:res) {
					sb.append(ch);
				}
				sb.append("\n");	
			}
				
			return;
		}
		
		for (int i = st; i < c; i++) {
			res[dep] = arr[i];
			permu(dep+1, i+1);
		}
	}

}