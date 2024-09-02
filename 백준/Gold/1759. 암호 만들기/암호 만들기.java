import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	/*
	 * 
	 * 
	 * 조건 a e i o u 중 최소 하나 꼭 사용 최소 두 개의 자음으로 구성 알파벳 암호에서 증가하는 순서로 배열
	 * 
	 */
	static int l, c;
	static String[] list;
	static String[] res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		l = sc.nextInt();
		c = sc.nextInt();

		list = new String[c];
		res = new String[l];
		
		for (int i = 0; i < c; i++) {
			list[i] = sc.next();
		}
		Arrays.sort(list);
//		System.out.println(Arrays.toString(list));
		
		combi(0,0);
		System.out.println(sb);
	}

	private static void combi(int cnt, int start) {
		if(cnt == l) {
			int check=0;
			int cs = l;//자음 개수 적어도 2개 이상
			for (int i = 0; i < res.length; i++) {
				if(res[i].equals("e")||res[i].equals("a")||res[i].equals("i")||res[i].equals("o")
						||res[i].equals("u")) {
					check++;
					cs--;
				}
			}
			if(cs>=2&&check>=1) {
				
				for (int j = 0; j < res.length; j++) {
					sb.append(res[j]);
					
				}
				sb.append('\n');
				
			}
//			System.out.println(Arrays.toString(res));
			return;
		}
		
		
		for (int i = start; i < c; i++) {
		
			res[cnt] = list[i];
			combi(cnt+1,i+1);
		}
	}

}