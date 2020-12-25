import java.util.Scanner;

public class Task1a {
	
	public static void main(String[] args) {

// ----------------- write your code BELOW this line only --------
// your code here (add lines)
		Scanner myScanner = new Scanner(System.in);
		int a = myScanner.nextInt();
		int b = myScanner.nextInt();
		int c = myScanner.nextInt();

		//The condition the variables needs to comply to (according to Pythagoras)
		if ((a > 0) && (a <= b) && (b <= c) && (a*a + b*b == c*c)){
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
// ----------------- write your code ABOVE this line only ---------
		
	}
}
