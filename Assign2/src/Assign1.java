import java.util.Scanner;

/**
 * This class contain the components to run the program and display it
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-07-17
 */
public class Assign1 {
    /**
     * Run the code
     * @param args The main part that run the whole program
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
            }while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7") && !input.equals("8"));
            switch (input) {
                case "1":
                    inventory.addItem(scanner, false);
                    break;
                case "2":
                    System.out.print(inventory.toString()+"\n");
                    break;
                case "3":
                    inventory.updateQuantity(scanner, true);
                    break;
                case "4":
                    inventory.updateQuantity(scanner, false);
                    break;
                case "5":
                    inventory.searchForItem(scanner);
                    break;
                case "6":
                    inventory.saveToFile(scanner);
                    break;
                case "7":
                    inventory.readFromFile(scanner);
                    break;
                case "8":
                    System.out.println("Exiting...");
                    break;
            }
        }while(!input.equals("8"));
    }
    /**Display the Menu*/
    public static void displayMenu(){
    System.out.print("Please select one of the following:\n" +
            "1: Add Item to Inventory\n" +
            "2: Display Current Inventory\n" +
            "3: Buy Item(s)\n" +
            "4: Sell Item(s)\n" +
            "5: Search for Item\n" +
            "6: Save Inventory to File\n" +
            "7: Read Inventory from File\n" +
            "8: To Exit\n" +
            "> ");
    }
}