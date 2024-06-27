import java.util.Scanner;

public class Main {

	static int n;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n];
		
		nqueen(0);

		System.out.println(cnt);
		

	}
	public static void nqueen(int depth) {
		if(depth==n) {
			cnt++;
			return; 
		}
		
		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if(possible(depth)) {
				nqueen(depth+1);
			}
		}
	}
	public static boolean possible(int col) {
		
		for (int i = 0; i < col; i++) {
			if(arr[i]==arr[col]) {
				return false;
			}
			else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) {
				return false;
			}
		}
		
		return true;
	}

}