import java.util.Iterator;

public class NumberTester
{
    public static void main(String[] args)
    {
        System.out.println("testNumber() = " + testNumber());
        System.out.println("testIsZero() = " + testIsZero());
        System.out.println("testBitIterator() = " + testBitIterator());
        System.out.println("testIncrement() = " + testIncrement());
        System.out.println("testIsLegal() = " + testIsLegal());
        System.out.println("testEquals() = " + testEquals());
        System.out.println("testToString() = " + testToString());
        System.out.println("testLessEq() = " + testLessEq());
        System.out.println("testLessThan() = " + testLessThan());
        System.out.println("testCompareTo() = " + testCompareTo());
        System.out.println("testAdd() = " + testAdd());
        System.out.println("testMultiply() = " + testMultiply());
    }

    // Testing the constructors
    public static boolean testNumber(){
    	Number n1 = new Number();
    	Number n2 = new Number(12);
    	Number n3 = new Number("354");
    	Number n4 = new Number(0);
    	Number n5 = new Number(n3);
    	Number n6 = new Number("0");
    	n1.toString().equals("0");
    	return n1.toString().equals("0") && 
    			n2.toString().equals("1100") && 
    			n3.toString().equals("101100010") && 
    			n4.toString().equals("0") &&
    			n5.toString().equals("101100010") &&
    			n6.toString().equals("0");
    }
    // Testing the methods
    
    public static boolean testIsZero(){
    	Number n1 = new Number();
    	Number n2 = new Number(12);
    	Number n3 = new Number(0);
    	Number n4 = new Number("0");
    	return n1.isZero() &&
    			!n2.isZero() &&
    			n3.isZero() &&
    			n4.isZero();
    }

    public static boolean testBitIterator(){
    	Number n1 = new Number();
    	Number n2 = new Number(12);
    	Number n3 = new Number(3);
    	Iterator<Bit> it1 = n1.bitIterator();
    	Iterator<Bit> it2 = n2.bitIterator();
    	Iterator<Bit> it3 = n3.bitIterator();
    	return it1.hasNext() && it1.next().isZero() && !it1.hasNext() &&
    			it2.hasNext() && it2.next().isZero() && it2.hasNext() &&
    			it2.next().isZero() && it2.hasNext() && it2.next().isOne() &&
    			it2.hasNext() && it2.next().isOne() && !it2.hasNext() &&
    			it3.hasNext() && it3.next().isOne() && it3.hasNext() && it3.next().isOne() && !it3.hasNext();
    }

    public static boolean testIncrement(){
    	Number n1 = new Number();
    	Number n2 = new Number(12);
    	Number n3 = new Number(13);
    	Number n4 = new Number(3);
    	Number n5 = new Number(Integer.MAX_VALUE);
    	n1.increment();
    	n2.increment();
    	n4.increment();
    	n5.increment();
    	return n1.equals(new Number(1)) &&
    			n2.equals(n3) &&
    			n4.equals(new Number(4)) &&
    			n5.toString().equals("10000000000000000000000000000000");
    }

    public static boolean testIsLegal(){
    	String s1 = null;
    	String s2 = new String("23$@ 56");
    	String s3 = new String("-56");
    	String s4 = new String("08");
    	String s5 = new String("12");
    	return !Number.isLegal(s1) &&
    			!Number.isLegal(s2) &&
    			!Number.isLegal(s3) &&
    			!Number.isLegal(s4) &&
    			Number.isLegal(s5);
    }

    public static boolean testEquals(){
    	Number num1 = new Number(29);
    	Number num2 = new Number(29);
    	Number num3 = new Number(5);
    	return num1.equals(num2) &&
    			!num1.equals(num3) &&
    			!num1.equals(null);
    }

    public static boolean testToString(){
    	Number n1 = new Number();
    	Number n2 = new Number(12345);
    	Number n3 = new Number (1);
    	return n1.toString().equals("0") &&
    			n2.toString().equals("11000000111001") &&
    			!n1.toString().equals(n2.toString()) &&
    			n3.toString().equals("1");
    }

    public static boolean testLessEq(){
    	Number num1 = new Number(7);
    	Number num2 = new Number(7);
    	Number num3 = new Number(2);
    	Number num4 = new Number(3); 
    	return !Number.lessEq(num4, num3) &&
    			Number.lessEq(num2, num1) &&
    			Number.lessEq(num3, num4) &&
    			Number.lessEq(num1, num2);
    }

    public static boolean testLessThan(){
    	Number num1 = new Number(6);
    	Number num2 = new Number(3); 
    	Number num3 = new Number(3);
    	return !Number.lessThan(num1, num3) &&
    			!Number.lessThan(num2, num2) &&
    			Number.lessThan(num2, num1);
    }

    // Testing static functions
    
    public static boolean testCompareTo(){
    	Number n1 = new Number();
    	Number n2 = new Number(12);
    	Number n3 = new Number(13);
    	return n1.compareTo(n3) == -1 &&
    			n2.compareTo(n2) == 0 &&
    			n3.compareTo(n2) == 1;
    }

    public static boolean testAdd(){
    	Number n1 = new Number();
    	Number n2 = new Number(12);
    	Number n3 = new Number(13);
    	Number n4 = new Number(3);
    	return Number.add(n1, n2).equals(n2) &&
    			Number.add(n3, n4).equals(new Number (16)) &&
    			Number.add(n1, n1).equals(n1) &&
    			!Number.add(n2, n3).equals(n4);
    }

    public static boolean testMultiply(){
    	Number n1 = new Number();
    	Number n2 = new Number(12);
    	Number n3 = new Number(4);
    	Number n4 = new Number(3);
    	return Number.multiply(n3, n4).equals(n2) &&
    			Number.multiply(n1, n2).equals(n1) &&
    			!Number.multiply(n2, n3).equals(n4);
    }
}