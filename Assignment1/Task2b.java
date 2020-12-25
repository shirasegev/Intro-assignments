import java.util.Scanner;

public class Task2b {

    public static void main(String[] args) {

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)
        Scanner myScanner = new Scanner(System.in);

        // Assume all variables are integers >= 0
        int n = myScanner.nextInt();
        int k = myScanner.nextInt();

        // To be able to find the reminder for n! for any big number n, we need to calculate the reminder
        // in every step. This is true because (a*b)%k = (a%k * b) %k. See below why:
        // (a*b)%k=?; a=x*k + r; a*b = (x*k + r)*b = x*b*k + r*b;
        // (a*b)%k = (x*b*k + r*b)%k = (r*b)%k
        
        int reminder = 1;
        for (int a = 1; a <= n; a = a + 1) {
            reminder = (reminder * a) % k;
        }

        System.out.println("n!%k = " + reminder);
        // ----------------- write your code ABOVE this line only ---------

    }
}
