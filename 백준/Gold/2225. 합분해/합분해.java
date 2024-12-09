import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int  n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] arr = new int[n+1][k+1];
		
		for(int i =0; i<=n ;i++){
			arr[i][0] = 0;
			arr[i][1] = 1;
			
		}
        for(int i=0;i<=k;i++){
            arr[1][i] = i;
        }
        
		for(int i =2; i<=n; i++) {
			for(int j =2; j<=k;j++) {
				arr[i][j] = (arr[i-1][j]+arr[i][j-1])%1000000000;
			}
		}
		System.out.println(arr[n][k]);
	}

}