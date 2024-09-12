import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 조합으로 풀자 정답 여러개시 아무거나 출력해도 되닊
	 */
	static int arr[];
	public static void main(String[] args) {
		
		arr = new int[9];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <9; i++) {
			arr[i] = sc.nextInt();
			
		}
		
		comb(0,0);
		for (int i = 0; i < 7; i++) {
		System.out.println(total[i]);
	}
	}
	static int sum = 0;
	
	static int[] res = new int[7];
	static int[] total = new int[7];
	private static void comb(int cnt,int start) {
		
		if(cnt== 7) {
			sum = 0;
			for (int i = 0; i < 7; i++) {
				sum +=res[i];

			}
//			System.out.println(Arrays.toString(res));
//			System.out.println(sum+"    ");
			if(sum==100) {
			Arrays.sort(res);
//			for (int i = 0; i < 7; i++) {
//				System.out.println(res[i]);
//			}
				total = res.clone();
//			System.out.println(Arrays.toString(res));
//			return;
		}

			return ;
			
		}
		
		for (int i = start; i < 9; i++) {
			res[cnt] = arr[i];
			comb(cnt+1,i+1);
		}
		
	}

}
