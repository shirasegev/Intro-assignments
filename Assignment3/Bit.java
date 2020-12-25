public class Bit {
	private boolean value;

	// Constructor
    public Bit(boolean value) {
    	this.value = value;
	}

    // Methods
    public String toString() {
    	String s;
    	if (!value)
    		s = "0";
    	else
    		s = "1";
    	
    	return s;
    }

    // The following method returns whether the value input is one or not
    public boolean isOne() {
		return value;
    }

    public boolean lessThan(Bit digit) {
    	return (digit.isOne() && !isOne());
	}

    public boolean lessEq(Bit digit) {
    	return (digit.isOne() || !isOne());
	}
    
    // Assisting method used at Task no. 9
    // The following converts Bit to int at current field
    private int toInt() {
    	int intValue;
    	if (value == true)
    		intValue = 1;
    	else
    		intValue = 0;
    	
    	return intValue;
    }

   public static Bit fullAdderSum(Bit A, Bit B, Bit Cin) {
	   // Assume all inputs are valid
	   boolean adderSum;
	   int sum = (A.toInt() + B.toInt() + Cin.toInt()) % 2;
	   
	   if (sum == 1)
		   adderSum = true;
	   else
		   adderSum = false;
	   
	   return new Bit (adderSum);
   }
   
   public static Bit fullAdderCarry(Bit A, Bit B, Bit Cin) {
	   // Assume all inputs are valid
	   boolean adderCarry;
	   int carry = (A.toInt() + B.toInt() + Cin.toInt()) / 2;
	  
	   if (carry == 1)
		   adderCarry = true;
	   else
		   adderCarry = false;
	   
	   return new Bit (adderCarry);
   }
}