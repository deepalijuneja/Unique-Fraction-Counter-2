/**
 * Driver class for homework 2. It's purpose is to count the number of unique fractions that is read from the fractions.txt file.
 * 
 * @author  Deepali Juneja
 * @version 13 April 2020
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FractionDriver {
    public static void main(String[] args) {
        File textFile= new File("fractions.txt");
        ArrayList<Fraction> fractions = new ArrayList<Fraction>();
        Scanner readFile;
        int Num, Den;
        String[] split = new String[2];
        Fraction addFraction;
        try {
            readFile = new Scanner(textFile);
            while (readFile.hasNextLine()) {
                split = readFile.nextLine().split("/");
                Num = Integer.parseInt(split[0]);
                Den = Integer.parseInt(split[1]);
                addFraction = new Fraction(Num, Den);
                fractions.add(addFraction);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, the system could not find your file.");
        }
        FractionCounter fracCounter = new FractionCounter(fractions);
        System.out.println(fracCounter);
    }
}