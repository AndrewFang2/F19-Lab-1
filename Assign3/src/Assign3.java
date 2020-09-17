import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contain the components to run the program and display it
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-08-05
*/

public class Assign3 {
    /**
     * Run the code
     * @param args The main part that run the whole program
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        LocalDate today = LocalDate.now();
        String input;
        do {
            do {
                displayMenu();
                input = scanner.next();
            }while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") && !input.equals("6") && !input.equals("7") && !input.equals("8") && !input.equals("9"));
            switch (input) {
                case "1":
                    inventory.addItem(scanner);
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
                    inventory.removeExpiredItems(today);
                    break;
                case "7":
                    inventory.printExpirySummary(scanner);
                    break;
                case "8":
                    boolean valid = false;
                    do {
                        try {
                            System.out.println("Please enter today's date (yyyy-mm-dd): ");
                            String date = scanner.next();
                            today = LocalDate.parse(date);
                            valid = true;
                                            
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid entry");
                            scanner.next();
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid format");
                            scanner.next();
                        }
                    } while (!valid);
                    break;
                case "9":
                    System.out.println("Exiting...");
                    break;
            }
        }while(!input.equals("9"));
    }
    /**Display the Menu*/
    public static void displayMenu(){
    System.out.print("Please select one of the following:\n" +
            "1: Add Item to Inventory\n" +
            "2: Display Current Inventory\n" +
            "3: Buy Item(s)\n" +
            "4: Sell Item(s)\n" +
            "5: Search for Item\n" +
            "6: Remove Expired Items\n" +
            "7: Print Expiry\n" +
            "8: Change Today's Date\n" +
            "9: To Exit\n" +
            "> ");
    }
}