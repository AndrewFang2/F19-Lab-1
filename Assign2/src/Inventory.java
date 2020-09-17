import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Create a space to store information and organize it
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-07-17
 */
public class Inventory {
    private ArrayList<FoodItem> inventory;
    /**Initialize value*/
    public Inventory(){
        inventory = new ArrayList<>();
    }
    /**Create a space to print out values in a list*/
    public String toString() {
        System.out.println("Inventory: ");
        bubble();
        StringBuilder str = new StringBuilder();
        for (FoodItem item : this.inventory) {
            if (item != null) {
                str.append(item.toString()).append("\n");
            }
        }
        return str.toString();
    }
    /**
     * Check if a code already exist and would return a number where it equals that value
     * @param item Allow item to enter
     * @return index of item or -1
     */
    public int alreadyExists(FoodItem item){
        for(int i = 0; i < this.inventory.size(); i++) {
            if(inventory.get(i)!= null) {
                if(item.isEqual(inventory.get(i))){
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * * Ask you what item you would like to add and check if it already exist or not
     * @param scanner allow using the same scanner used in other parts
     * @param fromFile check if you are trying to input a file or if you just want to input values
     * @return true unless already existed
     */
    public boolean addItem(Scanner scanner, boolean fromFile){
        String input;
        if(fromFile){
            input = scanner.next();
            switch (input) {
                case "f": {
                    Fruit fruit = new Fruit();
                    fruit.inputCode(scanner, true);
                    int var = alreadyExists(fruit);
                    if (var != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }
                    fruit.addItem(scanner, true);
                    inventory.add(fruit);
                    break;
                }
                case "v": {
                    Vegetable vegetable = new Vegetable();
                    vegetable.inputCode(scanner, true);
                    int var = alreadyExists(vegetable);
                    if (var != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }
                    vegetable.addItem(scanner, true);
                    inventory.add(vegetable);
                    break;
                }
                case "p": {
                    Preserve preserve = new Preserve();
                    preserve.inputCode(scanner, true);
                    int var = alreadyExists(preserve);
                    if (var != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }
                    preserve.addItem(scanner, true);
                    inventory.add(preserve);
                    break;
                }
            }
        }else {
            do {
                System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
                input = scanner.next();
                switch (input) {
                    case "f": {
                        Fruit fruit = new Fruit();
                        fruit.inputCode(scanner, false);
                        int var = alreadyExists(fruit);
                        if (var != -1) {
                            System.out.println("Item code already exists");
                            return false;
                        }
                        fruit.addItem(scanner, false);
                        inventory.add(fruit);
                        break;
                    }
                    case "v": {
                        Vegetable vegetable = new Vegetable();
                        vegetable.inputCode(scanner, false);
                        int var = alreadyExists(vegetable);
                        if (var != -1) {
                            System.out.println("Item code already exists");
                            return false;
                        }
                        vegetable.addItem(scanner, false);
                        inventory.add(vegetable);
                        break;
                    }
                    case "p": {
                        Preserve preserve = new Preserve();
                        preserve.inputCode(scanner, false);
                        int var = alreadyExists(preserve);
                        if (var != -1) {
                            System.out.println("Item code already exists");
                            return false;
                        }
                        preserve.addItem(scanner, false);
                        inventory.add(preserve);
                        break;
                    }
                    default:
                        System.out.println("Invalid entry");
                        break;
                }
            } while (!input.equals("f") && !input.equals("v") && !input.equals("p"));
        }
        return true;
    }
    /**
     * ask you if you would like to Buy/Sell and item and if you do how much do you need
     * @param scanner Take in variables
     * @param buyOrSell which if you would to buy or sell
     * @return true unless already exist or haven't enter value
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell){
        if(inventory.get(0)==null){
            System.out.println("Error...could not buy item");
            return false;
        }
        FoodItem foodItem = new FoodItem();
        boolean valid = false;
        int sellQuantity = 0;
        foodItem.inputCode(scanner,false);
        int var = alreadyExists(foodItem);
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
            if(sellQuantity > inventory.get(var).itemQuantityInStock){
                System.out.println("Error...could not buy item");
                return false;
            }else {
                inventory.get(var).updateItem(sellQuantity);
            }
        }else{
            if(sellQuantity > inventory.get(var).itemQuantityInStock){
                System.out.println("Error...could not sell item");
                return false;
            }else{
                inventory.get(var).updateItem(-sellQuantity);
            }
        }
        return true;
    }
    /**
     * print out the variable you want though itemCode
     * @param scanner Take in variables
     */
    public void searchForItem(Scanner scanner){
        FoodItem foodItem = new FoodItem();
        foodItem.inputCode(scanner,false);
        int var = alreadyExists(foodItem);
        if(var == -1) {
            System.out.println("Code not found in inventory...");
            return;
        }
        System.out.println(inventory.get(var));
    }
    /**
     * Make you save the variable you have enter into a file
     * @param scanner Take in variables
     */
    public void saveToFile(Scanner scanner){
        String file;
        Formatter writer= null;
        try {
            System.out.print("Enter the filename to save to: ");
            file = scanner.next();
            File outputTextFile = new File( "C:\\temp2020\\"+file );
            outputTextFile.createNewFile();

            int numOfItems=0;
            StringBuilder originalComponents = new StringBuilder();
            ArrayList<Integer> originalItemCodes= new ArrayList<Integer>();


            Scanner reader = new Scanner(outputTextFile);
            if (reader.hasNext()) {
                numOfItems= Integer.parseInt(reader.nextLine());
                while(reader.hasNext()) {
                    int itemCode = Integer.parseInt(reader.nextLine());
                    originalItemCodes.add(itemCode);
                    originalComponents.append(scanner.nextLine());
                    originalComponents.append(scanner.nextLine());
                    originalComponents.append(scanner.nextLine());
                    originalComponents.append(scanner.nextLine());
                }
            }
            reader.close();
            writer = new Formatter( outputTextFile );
            writer.flush();
            writer.format("%d", (int) numOfItems+inventory.size());
            if (!originalComponents.toString().replace(" ", "").isEmpty()) {
                writer.format("\n%s", originalComponents.toString());
            }

            for (FoodItem eachItem: inventory) {
                for (Integer originalCode: originalItemCodes) {
                    if (eachItem.getItemCode()==originalCode) {
                        System.out.println("ERROR: Duplicate item code");
                        throw new InputMismatchException();
                    }
                }
                if (eachItem instanceof Fruit) {
                    writer.format("\n%s", "f");
                }else if (eachItem instanceof Vegetable) {
                    writer.format("\n%s", "v");
                } else if (eachItem instanceof Preserve) {
                    writer.format("\n%s", "p");
                }else {
                    throw new InputMismatchException();
                }
                eachItem.outputItem(writer);
            }

        }catch (IOException | NumberFormatException | InputMismatchException e) {
            System.out.println("error");
        }
        assert writer != null;
        writer.close();
    }
    /**
     * allow you to print out data in a file into the program
     * @param scanner Take in variables
     */
    public void readFromFile(Scanner scanner) {
        String file;
        Scanner reader = null;
        try {
            System.out.print("Enter the filename to save to: ");
            file = scanner.next();
            File inputTextFile = new File("C:\\temp2020\\"+file );
            reader = new Scanner(inputTextFile);
            int numOfItems = reader.nextInt();
            if (!reader.hasNextLine()) {
                reader.close();
                return;
            }
            for (int i=0 ; i<numOfItems ; i++) {
                if (!addItem(reader, true)) {
                    throw new InputMismatchException();
                }
            }
            return;
        }catch (FileNotFoundException e) {
            System.out.println("File Not Found, ignoring...");
        }catch (InputMismatchException e) {
            System.out.println("Error Encountered while reading the file, aborting...");
        }
        try {
            assert reader != null;
            reader.close();
        }catch (NullPointerException ignored) {}
    }
    /**
     * A simple sorting algorithm
     */
    private void bubble() {
        FoodItem temp;
        if (inventory.size()>1){
            for (int x=0; x<inventory.size(); x++){
                for (int i=0; i < inventory.size() - 1; i++)
                    if (inventory.get(i).getItemCode() > inventory.get(i+1).getItemCode()){
                        temp = inventory.get(i);
                        inventory.set(i,inventory.get(i+1) );
                        inventory.set(i+1, temp);
                    }
                }
            }
        }
}