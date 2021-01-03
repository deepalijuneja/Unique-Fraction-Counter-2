/**
 * The purpose of this class is to represent the ratio of two numbers in the simplest form using the greatest common denominator.
 * 
 * @author Deepai Juneja
 * @version April 8, 2020
 */
public class Fraction {
    private int Num;//numerator
    private int Den;//denominator

    /**
     * The contructor below holds no argument.
     */
    public Fraction() {
        this.Num = 0;
        this.Den = 1;
        // 0/1 = 0
    }

    /**
     * In the constructor below, the division between the two numbers (numerator and denominator) occurs to derive the fraction in its reduced form using the greatest common denominator.
     * 
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        int greatestCD = 0;
        for (int i = 1; i <= numerator && i <= denominator; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                greatestCD = i;
            }
        }
        if (denominator != 0) {
            this.Num = Math.abs(numerator) / greatestCD;
            this.Den = Math.abs(denominator) / greatestCD;
        } else {
            throw new IllegalArgumentException("Division by zero is invalid, try a different number" ); // i think I did not have clear code for this part in last homework, so I was marked down. Hope this time it works!
        }
    }

    /**
     * The getter below reads the value of the numerator.
     * 
     * @return value of the numerator
     */
    public int getNum() {
        return this.Num;
    }

    /**
     * The getter below reads the value of the denominator.
     * 
     * @return value of the denominator 
     */
    public int getDen() {
        return this.Den;
    }

     /**
     * The setter below updates the value of the numerator 'n'.
     * 
     * @param n numerator.
     */
    public void setNum(int n) {
        this.Num = n;
    }

     /**
     *The setter below updates the value of the denominator 'd'.
     * 
     * @param d denominator.
     */
    public void setDen(int d) {
        if (d != 0) {
            this.Den = d;
        } else {
            throw new IllegalArgumentException("The denominator cannot be 0");
        }
    }
    

    /**
     * Below is the method that compares 'this' or the current fraction to the 'other' fraction which is the input.
     * 
     * @param compareFract 
     * @return true or false.
     */
    public boolean equals(Fraction compareFrac) {
        boolean output;
        double reducedFrac1 = this.getNum() / this.getDen();
        double reducedFrac2 = compareFrac.getNum() / compareFrac.getDen();
        if (reducedFrac1 == reducedFrac2) {
            output = true;
        } else {
            output = false;
        }
        return output;
    }
    
     /**
     * The final output/fraction class gets printed as a string.
     * 
     */
    @Override
    public String toString() {
        String output= "Fraction: " + getNum() + "/" + getDen();
        return output;
    }
}