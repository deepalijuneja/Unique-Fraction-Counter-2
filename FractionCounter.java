/**
 * This is the FractionCounter class. It takes an arraylist as an argument in the constructor and seperates the 
 * numerator and denominator into two separate arrays. 
 * 
 * @author Deepali Juneja
 * @version April 8, 2020
 */
import java.util.ArrayList;

public class FractionCounter {
    ArrayList<Fraction> allFrac;
    int[] Num;// numerator
    int[] Den;// denominator
    int counter;//
    int numberLines = 0;

    /**
     * We are only using one constructor in this entire class, and its purpose is basically to the entire array list of fractions and seperates them into two.
     * 
     * @param arrList the array list which contains all the fractions
     */
    public FractionCounter(ArrayList<Fraction> arrList) {
        this.numberLines = arrList.size();
        this.allFrac = arrList;
        this.Num = new int[numberLines];
        this.Den = new int[numberLines];

        for (int i = 0; i < numberLines; i++) {
            Num[i] = allFrac .get(i).getNum();
            Den[i] = allFrac .get(i).getDen();
        }
    }

    /**
     * Below is the private method which is used to compare and check if the the new fraction and the fraction we want to store are the same or not -> returns true, otherwise false. Also tells the no. of times a fraction occurs.
     *
     * @return
     */
    private String compareAndIncrement() {
        boolean[] check = new boolean[numberLines];
        int tNum, tDen;// temporarily holding the values
        String finalOutput = "";
        for (int i = 0; i < numberLines - 1; i++) {
            tNum = Num[i];
            tDen= Den[i];
            for (int j = 0; j < numberLines; j++) {
                if (!check[j]) {
                    if (tDen == Den[j] && tNum == Num[j]) {
                        counter++;
                        check[j] = true;
                    }
                }
            }
            if (counter != 0) {
                finalOutput+= tNum + "/" + tDen + " , therefore, this repeats these many " + counter + " times. \n";
            }
            counter = 0;
        }
        return finalOutput;
    }

     /**
     * Below is the method that prints the Fraction and its count. 
     */
     @Override
      public String toString() {
        return compareAndIncrement();
    }
}