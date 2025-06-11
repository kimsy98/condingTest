import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		StringTokenizer tokenizer = new StringTokenizer(string);
		
		System.out.println(tokenizer.countTokens());
		
	}

}