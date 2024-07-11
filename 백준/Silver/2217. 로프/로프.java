import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n  = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			max = Math.max(arr[i]*(n-i), max);
		}
		System.out.println(max);

	}

}