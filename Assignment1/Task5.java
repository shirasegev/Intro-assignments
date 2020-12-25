// You may not change or erase any of the lines and comments
// in this file. You may only add lines in the designated
// area.

import java.util.Scanner;

public class Task5 {


    public static void main(String[] args) {


        // ----------------- "A": write your code BELOW this line only --------
        // your code here (add lines)
        Scanner myScanner = new Scanner(System.in);
        int a = myScanner.nextInt();
        int b = myScanner.nextInt();
        int c = myScanner.nextInt();
        int d = myScanner.nextInt();
        int e = myScanner.nextInt();

        //Move the smallest number to a, and the largest to b
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (c > d) {
            int tmp = c;
            c = d;
            d = tmp;
        }
        if (a > c) {
            int tmp = a;
            a = c;
            c = tmp;
        }
        if (b > d) {
            int tmp = b;
            b = d;
            d = tmp;
        }
        if (a > e) {
            int tmp = a;
            a = e;
            e = tmp;
        }
        if (d > e) {
            int tmp = d;
            d = e;
            e = tmp;
        }
        System.out.println(a);
        System.out.println(e);
        // ----------------- "B" write your code ABOVE this line only ---------


    } // end of main
} //end of class Task5