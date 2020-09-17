import java.util.Formatter;
import java.util.Scanner;

/**
 * Create child class to store information specifically for Vegetable
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-07-17
 */
public class Vegetable extends FoodItem{
    private String farmName;
    /**Initialize value*/
    public Vegetable(){
        super();
    }
    /**Create a String and organizes the values into something readable*/
    public String toString() {
        return ("Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + df.format(itemPrice) +" cost: $"+ df.format(itemCost) + " farm supplier: " + farmName);
    }
    /**
     * Ask you for the name of the Farm
     * @param scanner Take in variables
     * @param fromFile check if you are trying to input a file or if you just want to input values
     * @return always true
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            if (fromFile) {
                if (!scanner.hasNextLine()) {
                    return false;
                }
                farmName = scanner.nextLine();
                return true;
            }else {
                System.out.print("Enter the name of the farm supplier: ");
                scanner.nextLine();
                farmName = scanner.nextLine();
            }
        }
        return true;
    }
    /**
     * information would be written
     * @param writer format the information
     */
    public void outputItem(Formatter writer) {
        super.outputItem(writer);
        writer.format("\n%s", farmName);
    }
}