import java.util.Scanner;

public class Task4c {

    public static void main(String[] args) {

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)
        Scanner myScanner = new Scanner(System.in);
        int a = myScanner.nextInt();
        int b = myScanner.nextInt();
        int c = myScanner.nextInt();
        int d = myScanner.nextInt();
        int e = myScanner.nextInt();
        int f = myScanner.nextInt();

        // Assume all variables are integers >= 0 and that b, d, f are > 0

        // Because the numbers are ints, division will not get us the right answer,
        // therefore, I checked the following as: (a/b + c/d + e/f) = 1 => adf + bcf + bde = bdf
        if ((a * d * f + b * c * f + b * d * e) == b * d * f) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        // ----------------- write your code ABOVE this line only ---------

    }
}
