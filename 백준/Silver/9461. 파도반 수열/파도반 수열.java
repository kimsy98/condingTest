import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int tc = sc.nextInt();
        long arr[]  = new long[100];

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;

        for(int i=5; i<100;i++){
            arr[i] = arr[i-5]+arr[i-4]+arr[i-3];
        }
        for(int i =0; i<tc; i++){
            int n = sc.nextInt();
            sb.append(arr[n-1]).append("\n");
        }
        System.out.println(sb);
    }
}