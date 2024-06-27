import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n,m;
	static int[] arr;
	static int[] res;
	static boolean[] check;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		res = new int[m];
		check = new boolean[n];
		
		for (int i = 1; i <= n; i++) {
			arr[i-1] =i; 
		}
		
		permutaion(0);
	}
	public static void permutaion(int cnt) {
		if(cnt==m) {
			for (int i = 0; i < m; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0; i<n;i++) {
			
			if(!check[i]) {
				check[i]=true;
				res[cnt] = arr[i];
				permutaion(cnt+1);
				check[i]=false;
				
			}
		}
	}

}