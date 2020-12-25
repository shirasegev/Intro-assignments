import java.util.Scanner;

public class Task4b {

    public static void main(String[] args) {

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)

        Scanner myScanner = new Scanner(System.in);
        int a = myScanner.nextInt();
        int b = myScanner.nextInt();
        int c = myScanner.nextInt();

        // Calculate gcd(a,b) using Euclides
        int x = a;
        int y = b;
        int r = x % y;
        while (r != 0) {
            x = y;
            y = r;
            r = x % y;
        }
        // Calculate lcm(a,b)
        int lcmab = a * b / y;

        // Calculate gcd(lcm(a,b),c)
        x = lcmab;
        y = c;
        r = x % y;
        while (r != 0) {
            x = y;
            y = r;
            r = x % y;
        }
        // Calculate lcm(lcm(a,b),c)
        int lcm = lcmab * c / y;

        System.out.println("lcm(a,b,c) = " + lcm);

        // ----------------- write your code ABOVE this line only ---------

    }
}