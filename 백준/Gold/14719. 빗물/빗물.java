import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int h,w;
		h = sc.nextInt();
		w = sc.nextInt();
		int[] arr = new int[w];
		for (int i = 0; i < w; i++) {
			arr[i] = sc.nextInt();
		}
		
		int res = 0;
		
		for (int i = 1; i < w-1; i++) {
			int left = 0;
			int right = 0;
			
			for (int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}
			for (int j = i+1; j < w; j++) {
				right = Math.max(right, arr[j]);
			}
			
			if(left>arr[i]&&right>arr[i]) res += Math.min(left, right) - arr[i];
			
		}
		System.out.println(res);
	}

}