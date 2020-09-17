import java.util.Scanner;
/**
 * This class contain the components to run the program and display it
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-06-17
 */
public class Assign1 {
    /**
     * Run the code
     * @param args
     */
    public static void main(String[] args) {
        FoodItem foodItem = new FoodItem();
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        String input;
        do {
            do {
                displayMenu();
                input = scanner.next();
            }while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5"));
            switch (input) {
                case "1":
                    inventory.addItem(scanner);
                    break;
                case "2":
                    System.out.print(inventory.toString());
                    break;
                case "3":
                    inventory.updateQuantity(scanner, true);
                    break;
                case "4":
                    inventory.updateQuantity(scanner, false);
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
            }
        }while(!input.equals("5"));
    }
    /**Display the Menu*/
    public static void displayMenu(){
    System.out.print("Please select one of the following:\n" +
            "1: Add Item to Inventory\n" +
            "2: Display Current Inventory\n" +
            "3: Buy Item(s)\n" +
            "4: Sell Item(s)\n" +
            "5: To Exit\n" +
            "> ");
    }
}