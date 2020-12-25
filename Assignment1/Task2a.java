import java.util.Scanner;

public class Task2a {
	
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------
		// your code here (add lines)

		Scanner myScanner = new Scanner(System.in);
		int n = myScanner.nextInt();
		int factorial = 1;
		for (int i = 1; i <= n; i = i + 1) {
			factorial = factorial * i;
		}
		System.out.println("n! = " + factorial);
		// ----------------- write your code ABOVE this line only ---------
	}
}
