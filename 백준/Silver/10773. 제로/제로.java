import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i <n; i++) {
			int item  = sc.nextInt();
			if(item!=0) {
				s.push(item);
			}else {
				s.pop();
				
			}
		}
		int res = 0;
		for (int num : s) {
			res+=num;
		}
		System.out.println(res);
	}

}