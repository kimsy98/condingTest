import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t= sc.nextInt();
		
		int[][] arr = new int[10001][4];
		arr[1][1]=1;
		arr[2][1]=1;
		arr[2][2]=1;
		arr[3][1]=1;
		arr[3][2]=1;
		arr[3][3]=1;
		
		
		for (int i = 4; i < 10001; i++) {
			arr[i][1]= arr[i-1][1];
			arr[i][2]= arr[i-2][1] + arr[i-2][2];
			arr[i][3]= arr[i-3][1] + arr[i-3][2] + arr[i-3][3];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			sb.append(arr[n][1]+arr[n][2]+arr[n][3]+"\n");
		}
		System.out.println(sb);
	}

}