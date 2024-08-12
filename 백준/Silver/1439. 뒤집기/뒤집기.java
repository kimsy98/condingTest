import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		char[] arr = sc.next().toCharArray();
		int one = 0;
		int zero = 0;
		
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]=='1') {//현재 1
				if(arr[i]!=arr[i+1]) {//다음수가 0일때`
					one++;
					if(i == arr.length-2&&arr[i+1]=='0') zero++;
				}
				else if(i == arr.length-2&&arr[i+1]=='1') one++;//마지막까지 0 일때
				else if(i == arr.length-2&&arr[i+1]=='0') {//마지막은 1 일때
					one++;
					zero++;
				}
			}else {//현재 0
				if(arr[i]!=arr[i+1]) {//다음수가 1일때
					zero++;
					if(i == arr.length-2&&arr[i+1]=='1') one++;
				}
				else if(i == arr.length-2&&arr[i+1]=='0') zero++;//마지막까지 0 일때
				else if(i == arr.length-2&&arr[i+1]=='1') {//마지막은 1 일때
					one++;
					zero++;
				}
				
			}
		}
		int res = 0;
		if(one==0||zero==0)res = 0;
		else res = Math.min(one, zero);
		System.out.println(res);
	}

}