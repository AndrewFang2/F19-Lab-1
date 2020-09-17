import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
/**
 * Connect Inventory with foodItem 
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-08-05
 */
public class InventoryItem {
    private int itemQuantityInStock;
    private FoodItem item;
    private ArrayList<LocalDate> expiries;
    /**
     * declare the variable and set it
     * @param item relate it to the food item
     */
    public InventoryItem(FoodItem item){
        this.itemQuantityInStock = 0;
        this.item = item;
        this.expiries = new ArrayList<LocalDate>();
    }
    /**
     * ask for quantity and expiry
     * @param scanner Take in variables
     * @return always true
     */
    public boolean addItem(Scanner scanner){
        item.addItem(scanner);
        boolean valid = true;
        
        do {
            try {
                System.out.print("Enter the quantity for the item: ");
                itemQuantityInStock = scanner.nextInt();
                if (itemQuantityInStock > 0)
                    valid = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry");
                scanner.next();
            }
        } while (valid);
        valid = true;
        do {
            try {
                System.out.print("Enter the expiry date of the item (yyyy-mm-dd or none): ");
                
                String date = scanner.next();
                LocalDate localDate;

                if (date.equals("none")){
                    localDate = LocalDate.MAX;
                } else {         
                    localDate = LocalDate.parse(date);
                }
                for(int i=0; i<itemQuantityInStock; i++) {
                    expiries.add(localDate);
                }
                valid = false;
                                
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry");
            } catch (DateTimeParseException e) {
                System.out.println("Could not parse not date");
            }

        } while (valid);
        return true;
    }

    /**
     * a get method for ItemCode
     * @return return getItemCode
     */
    public int getItemCode(){
        return item.getItemCode();
    }
    /**
     * a get method for ItemCode
     * @return return inputCode
     */
    public boolean inputCode(Scanner scanner) {
        return item.inputCode(scanner);
    }
    /**
     * Create a summary for Expiry of a certain number
     */
    public void printExpirySummary(){
        Collections.sort(expiries);
        System.out.println("\nExpiry Details: ");
        for (int i = 0; i < expiries.size(); i++) {
            LocalDate first = expiries.get(i);
            int expDates = 1;
            while (i + 1 < expiries.size() && first.equals(expiries.get(i + 1))) {
                expDates++;
                i++;
            }
            if (first == LocalDate.MAX) {
                System.out.print("No Expiry : " + expDates +"\n");  
            }else{
                System.out.print(first + ": " + expDates +"\n");  
            }
        }
    }

    /**
     * remove any expired item from the database
     * @param today take the date and compare it to the other days
     */
    public void removeExpiredItems(LocalDate today){
        Collections.sort(expiries);
        int listSize = expiries.size();
        for(int i=0; i<listSize; i++) {
            if (today.isAfter(LocalDate.from(expiries.get(0)))) {
                expiries.remove(0);
                itemQuantityInStock--;
            }
                
        }
    }

    /**
     *
     * @param scanner Take in variables
     * @param amount
     * @return always true
     */
    public boolean updateQuantity(Scanner scanner, int amount){
        int total = amount + itemQuantityInStock;
        if(total<0){
            return false;
        }else{
            itemQuantityInStock = total;
            return true;
        }
    }
    /**Create a String and organizes the values into something readable*/
    public String toString(){   
        return (item.toString() + " qty: " +  itemQuantityInStock);
    }
    /**
     * a get method for FoodItem
     * @return return getFoodItem
     */
    public FoodItem getFoodItem(){
        return item;
    }
    /**
     * a get method for Expiries
     * @return return getExpiries
     */
    public ArrayList<LocalDate> getExpiries(){
        return expiries;
    }
    /**
     * add a expiry
     */
    public void addExpiry(LocalDate localDate) {
        expiries.add(localDate);
    }
    /**
     * a get method for itemQuantityInStock
     * @return return itemQuantityInStock
     */
    public int getItemQuantityInStock(){
        return itemQuantityInStock;
    }


}
