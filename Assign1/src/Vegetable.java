import java.util.Scanner;
/**
 * Create child class to store information specifically for Vegetable
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-06-17
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
     * @param scanner
     * @return always true
     */
    public boolean addItem(Scanner scanner){
        super.addItem(scanner);
        System.out.print("Enter the name of the farm supplier: ");
        farmName = scanner.next();
        scanner.nextLine();
        return true;
    }
}