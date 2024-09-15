import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] A = new int[n];
		Integer[] B = new Integer[n];
		
		st =new StringTokenizer(br.readLine());
		for(int i=0; i<n;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st =new StringTokenizer(br.readLine());		
		for(int i=0; i<n;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B, Comparator.reverseOrder());
//		Arrays.sort(B, new Comparator<T>() {
//            // Override된 compare 함수를 어떻게 정의하냐에 따라서 다양한 정렬이 가능해집니다
//            @Override
//            public int compare(int o1, int o2) {
//                 return o2 - o1;
//            }
//        });
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += A[i]*B[i];
		}
		
		System.out.println(sum);
	}

}