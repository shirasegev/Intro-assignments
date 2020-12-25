import java.util.Scanner;

public class Task1b {

    public static void main(String[] args) {

// ----------------- write your code BELOW this line only --------
// your code here (add lines)
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt(); //Assume variable is integer >= 0

        //Defining the relation between a, b and c
        for (int a = 1; a <= n; a = a + 1) {
            for (int b = a; b <= n; b = b + 1) {
                for (int c = b; c <= n; c = c + 1) {
                    //The condition the variables needs to comply to (according to Pythagoras)
                    if (a * a + b * b == c * c) {
                        System.out.println(a + " " + b + " " + c);
                    }
                }
            }
        }
// ----------------- write your code ABOVE this line only ---------

    }
}
