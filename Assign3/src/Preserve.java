import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Create child class to store information specifically for Preserve
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-08-05
 */
public class Preserve extends FoodItem {
    private int jarSize;
    /**Initialize value*/
    public Preserve(){
        super();
    }
    /**Create a String and organizes the values into something readable*/
    public String toString() {
        return ("Item: " + itemCode + " " + itemName + " price: $"  + df.format(itemPrice) + " cost: $" + df.format(itemCost) + " size: " + jarSize + "mL");
    }

    /**
     * Ask you for the size of the Preserve
     * @param scanner Take in variables
     * @return always true
     */
    public boolean addItem(Scanner scanner){
        super.addItem(scanner);
        boolean invalid = false;
        do {
            try {
                System.out.print("Enter the size of the jar in millilitres: ");
                jarSize = scanner.nextInt();
                if (jarSize > 0)
                    invalid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry");
                scanner.next();
            }
        } while (!invalid);
        return true;
    }
    /**
     * information would be written
     * @param writer format the information
     */
    public void outputItem(Formatter writer) {
        super.outputItem(writer);
        writer.format("\n%s", jarSize);
    }
}
