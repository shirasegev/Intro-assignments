import java.util.Iterator;
import java.util.Set;

public class Number implements Comparable<Number> {
    private static final int BASE = 2;
    private static final Number ZERO = new Number();
    private static final Number ONE = new Number(1);
    private List<Bit> list;
	
    // Constructors
    
    /**
     * Constructs a new Number defaulted to the value zero.
     */
    // An empty constructor
    public Number(){
        list = new LinkedList<Bit>();
        list.add(new Bit(false));
    }

    /**
     * Constructs a new Number from an int.
     * @param number an int representing a decimal number
     */
    public Number(int number){  // assignment #1
    	// Check if input is valid
    	if (number < 0) {
    		throw new IllegalArgumentException("Argument must be a natural number");
    	}
    	// initializing a number assisting an outer function
    	init (number);
    }

    /**
     * Constructs a new Number from a String.
     * @param s a String (possibly) representing a decimal number.
     */
    public Number(String s){    // assignment #2
    	// Check if input is valid
    	if (!isLegal(s)) {
    		throw new IllegalArgumentException("Argument must be a natural number");
    	}
    	int number = 0;
    	// Convert a decimal number legal string to a binary represented number
    	for (int i = 0; i < s.length(); i = i + 1) {
    			number = number*10 + s.charAt(i)-'0';
    	}
    	// initializing a number assisting an outer function
    	init(number);
    }

    /**
     * Constructs a new Number which is a deep copy of the provided Number.
     * @param number a Number to be copied
     */
    public Number(Number number){ // assignment #3
    	// Check if input is valid
    	if (number == null) {
    		throw new IllegalArgumentException("Argument can't be null");
    	}
    	// crate a new list to which we copy the values of number list
    	list = new LinkedList<Bit>();
    	Iterator<Bit> iter = number.list.iterator();
    	// Use bit iterator to get each bit at the copied list
    	while (iter.hasNext()) {
    		list.add(new Bit(iter.next().getValue()));
    	}
    }
    
    // Assisting function for the constructors at tasks 1 & 2
    private void init (int number) {
    	list = new LinkedList<Bit>();
    	// Use do while loop to deal with number = zero
    	do {
    		Bit bit = new Bit(number % BASE == 1);
    		list.add(bit);
    		number = number / BASE;
    	} while (number > 0);
    }

    // Methods
    
    /**
     * Checks if this Number is zero.
     * @return true if and only if this object representing the number zero.
     */
    public boolean isZero(){ // assignment #4
    	return (list.size() == 1 && list.get(0).isZero());
    }

    /**
     * Returns an iterator over the Bit objects in the representation of this number,
     * which iterates over the Bit objects from LSB (first) to MSB (last).
     * @return a LSB-first iterator over the Bit objects in the representation of this number.
     */
    public Iterator<Bit> bitIterator(){ // assignment #5
    	return list.iterator();
    }

    /**
     * Adds 1 to the number
     */
    public void increment(){ // assignment #6
    	// Create new Bits, so we can use fullAdderSum and fullAdderCarry later on
    	// carry holds the value of 1, because it is easier to summaries this way
    	// set method changes current Bit value according to the sum result
    	Bit zero = new Bit (false);
    	Bit carry = new Bit (true);
    	for (Bit bit : list) {
    		Bit sum = Bit.fullAdderSum(bit, zero, carry);
    		carry = Bit.fullAdderCarry(bit, zero, carry);
    		bit.setValue(sum.getValue());
    	}
    	// Taking care of the option that the size of number increment at 1 as well
    	if (carry.isOne()) {
    		list.add(carry);
    	}
    }
    
    /**
     * Checks if a provided String represent a legal decimal number.
     * @param s a String that possibly represents a decimal number, whose legality to be checked.
     * @return true if and only if the provided String is a legal decimal number
     */
    public static boolean isLegal(String s){ // assignment #7
    	boolean valid = true;
    	if (s == null || s.length() == 0 || (s.length() > 1 && s.charAt(0) == '0')) {
    		valid = false;
    	}
    	// Makes sure s represented value made out of only 0 to 9 digits
    	for (int i = 0; valid && i < s.length(); i = i + 1) {
    		if (s.charAt(i) < '0' || s.charAt(i) > '9') {
    			valid = false;
    		}
    	}
        return valid;
    }

    /**
     * Compares the specified object with this Number for equality.
     * Returns true if and only if the specified object is also a
     * Number (object) which represents the same number.
     * @param obj he object to be compared for equality with this Number
     * @return true if and only if the specified object is equal to this object
     */
    public boolean equals(Object obj){ // assignment #8
    	boolean isEqual = true;
    	// The following are cases where equals method will return a false reply 
    	if (obj == null || !(obj instanceof Number)) {
    		isEqual = false;
    	}
    	else if (!list.equals(((Number)obj).list)) {
    		isEqual = false;
    	}
        return isEqual;
    }
    
    /**
     * Returns a string representation of this Number
     * as a binary number.
     * @return a string representation of this Number
     */
    public String toString(){ // assignment #9
    	// Using iterator to convert Number to a string
    	// Adding the value at last to reveres the  presentation
    	String string = "";
    	for (Bit bit : list) {
    		string = bit + string;
    	}
    	return string;
    }

    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is less than or equal to the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is less than
     * or equal to the second parameter, as numbers.
     */
    public static boolean lessEq(Number num1, Number num2){ // assignment #10
    	if (num1 == null || num2 == null) {
    		throw new IllegalArgumentException ("input can not be null");
    	}
    	return (num1.compareTo(num2) <= 0);
    }

    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is strictly less than the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is strictly
     * less than the second parameter, as numbers.
     */
    public static boolean lessThan(Number num1, Number num2){ // assignment #11
    	if (num1 == null || num2 == null) {
    		throw new IllegalArgumentException ("input can not be null");
    	}
    	return num1.compareTo(num2) < 0;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Number o){ // assignment #12
    	if (o == null) {
    		throw new IllegalArgumentException ("input can not be null");
    	}
    	int compared = 0;
    	boolean equal = true;
    	boolean less = false;
    	Iterator<Bit> num1Iter = bitIterator();
    	Iterator<Bit> num2Iter = o.bitIterator();

        // Check when num1 is NOT less than num2
    	while (num1Iter.hasNext() && num2Iter.hasNext()) {
        	Bit bit1 = num1Iter.next();
        	Bit bit2 = num2Iter.next();
        	// If one is less than the other, the case of equality is covered
        	if (bit2.lessThan(bit1)) {
        		less = false;
        		equal = false;
       		}
       		else if (bit1.lessThan(bit2)) {
       			less = true;
       			equal = false;
       		}
       	}
        // Complete all possible cases
        if (num2Iter.hasNext()) {
        	less = true;
        	equal = false;
        }
        else if (num1Iter.hasNext()) {
        	less = false;
        	equal = false;
        }
        // follow the "contract" of the method implement
        if (less) {
    		compared = -1;
    	}
    	else if (!equal) {
    		compared = 1;
    	}
    	return compared;
    }

    // Static functions

    /**
     * Adds the specified Number objects, and returns their sum.
     * @param num1 the first addend
     * @param num2 the second addend
     * @return the sum of the specified Number objects.
     */
    public static Number add(Number num1, Number num2){ // assignment #13
    	if (num1 == null || num2 == null) {
    		throw new IllegalArgumentException ("input can not be null");
    	}
    	// Create a new Number, that will represent the summary of num 1 and num 2
    	// and to avoid the first zero value that the empty constructor creates
    	Number sumNum = new Number ();
    	// Initialize two bits to a zero value, one for the carry
    	// and the other for a cause explained later
    	Bit carry = new Bit (false);
    	Bit zero = new Bit (false);
    	List<Bit> list = new LinkedList<Bit>();

    	Iterator<Bit> num1Iter = num1.bitIterator();
    	Iterator<Bit> num2Iter = num2.bitIterator();
    	
    	while (num1Iter.hasNext() || num2Iter.hasNext()) {
    		// If one of the accepted numbers is shorter than the other,
    		// we add a zero value until both numbers are summed to each other
    		Bit a = zero;
    		if (num1Iter.hasNext()) {
    			a = num1Iter.next();
    		}
    		Bit b = zero;
    		if (num2Iter.hasNext()) {
    			b = num2Iter.next();
    		}
    		Bit sum = Bit.fullAdderSum(a, b, carry);
        	list.add(sum);
        	carry = Bit.fullAdderCarry(a, b, carry);
    	}
    	// Taking care of the option that the size of number increments at 1 as well
    	if (carry.isOne()) {
    		list.add(carry);
    	}
    	// Place the summed number in a list as wanted
    	sumNum.list = list;
    	return sumNum;
    }

    /**
     * Multiply the specified Number objects, and returns their product.
     * @param num1 the first factor
     * @param num2 the second factor
     * @return the product of the specified Number objects.
     */
    public static Number multiply(Number num1, Number num2){ // assignment #14
    	if (num1 == null || num2 == null) {
    		throw new IllegalArgumentException ("input can not be null");
    	}
    	// Create a new Number, that will represent the multiplication of num1 and num2
    	Number multNum = new Number ();
    	Iterator<Bit> num1Iter = num1.bitIterator();
    	Number num2copy = new Number (num2);
    	
    	while (num1Iter.hasNext()) {
    		Bit bit1 = num1Iter.next();
    		// If the current Bit at num1 is Zero, it adds nothing to the summary
    		// But, if it is One, num2 will not change at all,
    		// Beside the indentation needed in a long multiplication
    		// Which we add anyway, whether if the bit value is zero or one. 
    		if (bit1.isOne()) {
    			multNum = add(multNum, num2copy);
        	}
    		// Add a zero bit to the list of the number that we multiply with (num2)
        	num2copy.list.add(0, new Bit(false));
    	}
    	// return the result of the multiplication of num1 * num2 as needed
    	return multNum;
    }
}