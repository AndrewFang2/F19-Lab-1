import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Create a space to store information and organize it
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-08-05
 */
public class Inventory {
    private ArrayList<InventoryItem> inventory;
    /**Initialize value*/
    public Inventory(){
        inventory = new ArrayList<>();
    }
    /**Create a space to print out values in a list*/
    public String toString() {
        System.out.println("Inventory: ");
        bubble();
        StringBuilder str = new StringBuilder();
        for (InventoryItem item : this.inventory) {
            if (item != null) {
                str.append(item.toString()).append("\n");
            }
        }
        return str.toString();
    }
    /**
     * Check if a code already exist and would return a number where it equals that value
     * @return index of item or -1
     */
    public int alreadyExists(InventoryItem inventoryItem){
        for(int i = 0; i < this.inventory.size(); i++) {
            if(inventory.get(i)!= null) {
                if(inventoryItem.getFoodItem().isEqual(inventory.get(i).getFoodItem())){
                    return i;
                }
            }
        }
        return -1;
    }
    /**
     * * Ask you what item you would like to add and check if it already exist or not
     * @param scanner allow using the same scanner used in other parts
     * @return true unless already existed
     */
    public boolean addItem(Scanner scanner){
        String input;
        do {
            System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
            input = scanner.next();
            switch (input) {
                case "f": {
                    Fruit fruit = new Fruit();
                    InventoryItem inventoryItem = new InventoryItem(fruit);

                    fruit.inputCode(scanner);
                    int var = alreadyExists(inventoryItem);
                    
                    if (var != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }
                    
                    inventoryItem.addItem(scanner);
                    inventory.add(inventoryItem);
                    break;
                }
                case "v": {
                    Vegetable vegetable = new Vegetable();
                    InventoryItem inventoryItem = new InventoryItem(vegetable);

                    vegetable.inputCode(scanner);
                    int var = alreadyExists(inventoryItem);

                    if (var != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }
                    
                    inventoryItem.addItem(scanner);
                    inventory.add(inventoryItem);
                    break;
                }
                case "p": {
                    Preserve preserve = new Preserve();
                    InventoryItem inventoryItem = new InventoryItem(preserve);

                    preserve.inputCode(scanner);
                    int var = alreadyExists(inventoryItem);

                    if (var != -1) {
                        System.out.println("Item code already exists");
                        return false;
                    }

                    inventoryItem.addItem(scanner);
                    inventory.add(inventoryItem);
                    break;
                }
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        } while (!input.equals("f") && !input.equals("v") && !input.equals("p"));
        return true;
    }
    /**
     * ask you if you would like to Buy/Sell and item and if you do how much do you need
     * @param scanner Take in variables
     * @param buyOrSell which if you would to buy or sell
     * @return true unless already exist or haven't enter value
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell){
        if(inventory.size()==0){
            System.out.println("Error...could not buy item");
            return false;
        }

        FoodItem foodItem = new FoodItem();
        foodItem.inputCode(scanner);
        InventoryItem inventoryItem = new InventoryItem(foodItem);

        boolean valid = true;
        int sellQuantity = 0;        
        
        int var = alreadyExists(inventoryItem);

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
            inventory.get(var).updateQuantity(scanner, sellQuantity);
        }else{
            if(sellQuantity > inventory.get(var).getItemQuantityInStock()){
                System.out.println("Error...could not sell item");
                return false;
            }else{
                inventory.get(var).updateQuantity(scanner, -sellQuantity);
            }
        }

        if(buyOrSell){
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

                    for(int i = 0; i < inventory.size(); i++){
                        if(inventory.get(i).getItemCode() == foodItem.itemCode){
                            for(int j = 0; j < sellQuantity; j++){
                                inventory.get(i).addExpiry(localDate);
                            }
                        }
                    }
                    valid = false;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid entry");
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid format");
                }
            } while (valid);
        }
        return true;
    }
    /**
     * print out the variable you want though itemCode
     * @param scanner Take in variables
     */
    public void searchForItem(Scanner scanner){
        FoodItem foodItem = new FoodItem();
        InventoryItem inventoryItem = new InventoryItem(foodItem);

        inventoryItem.inputCode(scanner);
        
        int var = alreadyExists(inventoryItem);
        if(var == -1) {
            System.out.println("Code not found in inventory...");
            return;
        }
        System.out.println(inventory.get(var));
    }
    /**
     * Make you save the variable you have enter into a file
     * @param scanner Take in variables

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
     */
    /**
     * allow you to print out data in a file into the program
     * @param scanner Take in variables

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
     */
    /**
     * direct you to InventoryItem removeExpiredItem for each item
     * @param today Take the date and check it with other product
     */
    public void removeExpiredItems(LocalDate today) {
        for(int i = 0; i < inventory.size(); i++){
            inventory.get(i).removeExpiredItems(today);
        }
    }
    /**
     * direct you to InventoryItem printExpirySummary
     * @param scanner get the scanner from main
     */
    public void printExpirySummary(Scanner scanner){
        FoodItem foodItem = new FoodItem();
        InventoryItem inventoryItem = new InventoryItem(foodItem);
        inventoryItem.inputCode(scanner);
        int var = alreadyExists(inventoryItem);
        if(var == -1) {
            System.out.println("Code not found in inventory...");
            return;
        }
        System.out.print(inventory.get(var).toString());
        inventory.get(var).printExpirySummary();
    }
    /**simple bubble sorting algorithm*/
    private void bubble() {
        InventoryItem temp;
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