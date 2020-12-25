// You may not change or erase any of the lines and comments
// in this file. You may only add lines.

public class Task6 {

    public static void main(String[] args) {

        // ----------------- write any code BELOW this line only --------
        // your code here (add lines)
        // ----------------- write any code ABOVE this line only ---------

        boolean isVerified = true;

        //Check all possible 2^5 cases
        for (int i = 0; i <= 1 & isVerified; i = i + 1) {
            for (int j = 0; j <= 1 &isVerified; j = j + 1) {
                for (int k = 0; k <= 1 & isVerified; k = k + 1) {
                    for (int l = 0; l <=  1 &isVerified; l = l + 1) {
                        for (int m = 0; m <= 1 & isVerified; m = m + 1) {
                            int a = i;
                            int b = j;
                            int c = k;
                            int d = l;
                            int e = m;

        // -----------------  copy here the code from Task 5 that is between
        // -----------------  the comments "A" and "B"
        // code from Task 5 here
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
        // -----------------  end of copied code from Task 5


        // ----------------- write any code BELOW this line only --------
        // your code here (add lines)
                            //Check that the program works
                            //So if it doesn't, the first time it fails
                            //it will print the failing case and get out of the loop
                            if (!(a <= b & a <= c & a <= d & e >= b & e >= c & e >= d)) {
                                isVerified = false;
                                System.out.println(a);
                                System.out.println(b);
                                System.out.println(c);
                                System.out.println(d);
                                System.out.println(e);
                            }
                        }
                    }
                }
            }
        }
        //Check that all cases are successful
        if (isVerified) {
            System.out.println("verified");
        }
        // ----------------- write any code ABOVE this line only ---------

    } // end of main
} //end of class Task6
//