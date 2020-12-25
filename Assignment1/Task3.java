import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)
        Scanner myScanner = new Scanner(System.in);

        // Assume variable is integer >= 0
        int n = myScanner.nextInt();

        //Find all prime divisors for n
        //And how many times it appears
        for (int divisor = 2; n != 1; divisor = divisor + 1) {
            int counter = 0;
            while (n % divisor == 0) {
                n = n / divisor;
                counter = counter + 1;
            }
            if (counter == 1) {
                System.out.println(divisor);
            }
            else if (counter > 1) {
                System.out.println(divisor + " " + counter);
            }
        }
        // ----------------- write your code ABOVE this line only ---------
    }
}