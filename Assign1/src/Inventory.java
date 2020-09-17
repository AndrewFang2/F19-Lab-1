import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Create a space to store information and organize it
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-06-17
 */
public class Inventory {
    private FoodItem[] inventory;
    private int numItems;
    /**Initialize value*/
    public Inventory(){
        numItems = 20;
        inventory = new FoodItem[numItems];
    }
    /**Create a space to print out values in a list*/
    public String toString() {
        System.out.println("Inventory: ");
        String str = "";
        for(int i = 0; i < numItems; i++) {
            if(inventory[i]!= null) {
                str += inventory[i].toString() + "\n";
            }
        }
        return str;
    }
    /**
     * Check if a code already exist and would return a number where it equals that value
     * @param item
     * @return index of item or -1
     */
    public int alreadyExists(FoodItem item){
        for(int i = 0; i < numItems; i++) {

            if(inventory[i]!= null) {
                if(item.isEqual(inventory[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * Ask you what item you would like to add and check if it already exist or not
     * @param scanner
     * @return true unless already existed
     */
    public boolean addItem(Scanner scanner){
        String input;

        for(int i = 0; i < numItems; i++) {
            if(inventory[i] == null){
                do {
                    System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
                    input = scanner.next();
                    if (input.equals("f")) {
                        Fruit fruit = new Fruit();
                        fruit.inputCode(scanner);
                        int var = alreadyExists(fruit);
                        if(var != -1) {
                            System.out.println("Item code already exists");
                            return false;
                        }
                        fruit.addItem(scanner);
                        inventory[i]=fruit;
                    } else if (input.equals("v")) {
                        Vegetable vegetable = new Vegetable();
                        vegetable.inputCode(scanner);
                        int var = alreadyExists(vegetable);
                        if(var != -1) {
                            System.out.println("Item code already exists");
                            return false;
                        }
                        vegetable.addItem(scanner);
                        inventory[i]=vegetable;
                    } else if (input.equals("p")) {
                        Preserve preserve = new Preserve();
                        preserve.inputCode(scanner);
                        int var = alreadyExists(preserve);
                        if(var != -1) {
                            System.out.println("Item code already exists");
                            return false;
                        }
                        preserve.addItem(scanner);
                        inventory[i]=preserve;
                    } else {
                        System.out.println("Invalid entry");
                    }
                }while(!input.equals("f") && !input.equals("v") && !input.equals("p"));
                break;
            }

        }
        return true;
    }
    /**
     * ask you if you would like to Buy/Sell and item and if you do how much do you need
     * @param scanner
     * @param buyOrSell
     * @return true unless already exist or haven't enter value
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell){
        if(inventory[0]==null){
            System.out.println("Error...could not buy item");
            return false;
        }
        FoodItem foodItem = new FoodItem();
        boolean valid = false;
        int sellQuantity = 0;
        foodItem.inputCode(scanner);
        int var = alreadyExists(foodItem);
        System.out.println(var);
        if(buyOrSell){
            if(var == -1) {
                System.out.println("Error...could not buy item");
                return false;
            }
        } else{
            if(var == -1) {
                System.out.println("Error...could not sell item");
                return false;
            }
        }

        do{
            try {
                if(buyOrSell){
                    System.out.print("Enter valid quantity to buy: ");
                }else{
                    System.out.print("Enter valid quantity to sell: ");
                }
                sellQuantity = scanner.nextInt();
                System.out.println(sellQuantity);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry");
                scanner.next();
            }
        }while(!valid);
        if(buyOrSell){
            if(sellQuantity > inventory[var].itemQuantityInStock){
                System.out.println("Error...could not buy item");
                return false;
            }else {
                inventory[var].updateItem(sellQuantity);
            }
        }else{
            if(sellQuantity > inventory[var].itemQuantityInStock){
                System.out.println("Error...could not sell item");
                return false;
            }else{
                inventory[var].updateItem(-sellQuantity);
            }
        }
        return true;
    }
}
