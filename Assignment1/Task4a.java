import java.util.Scanner;

public class Task4a {

    public static void main(String[] args) {

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)

        Scanner myScanner = new Scanner(System.in);
        int a = myScanner.nextInt();
        int b = myScanner.nextInt();
        int c = myScanner.nextInt();

        // Calculate gcd(a,b) using Euclid algorithm as learned in lecture
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        // Calculate gcd(a,b,c) using Euclid algorithm as learned in lecture.
        // Using the attached math fact- gcd(a,b,c)=gcd(gcd(a,b),c)
        // b contains the gcd(a,b) from previous step
        r = b % c;
        while (r != 0) {
            b = c;
            c = r;
            r = b % c;
        }
        System.out.println("gcd(a,b,c) = " + c);

        // ----------------- write your code ABOVE this line only ---------

    }
}
