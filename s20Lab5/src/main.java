import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class contains a program that searches an array for values
 * Student Name:Andrew Fang
 * Student Number:040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @author Andrew Fang
 */

public class main {
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        int index;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> item = new ArrayList<Integer>();
        String choice = "";
        do {
            displayMainMenu();
            choice = keyboard.next();
            while (choice.equals(null) || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
                choice = keyboard.nextLine();
                System.out.println("try again ");
                continue;
            }
            if (choice.equals("1")) {
                System.out.println("Please specify an Integer: ");
                item.add(scanner.nextInt());
            } else if (choice.equals("2")) {
                System.out.println("Please specify an Integer: ");
                index=BinarySearch(item,scanner.nextInt());
                if(index==-1) System.out.println("Index of integer is : not found");
                else System.out.println("Index of integer is : "+ index);

            } else if (choice.equals("3")) {
                System.out.println(item);
            } else {
                continue;
            }
        }while(choice.equals ("1") || choice.equals ("2") || choice.equals ("3"));
        System.out.println("Exiting...");
    }
    public static int BinarySearch(ArrayList<Integer> item, int num){

        int low = 0;
        int mid;
        int high = item.size() - 1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (item.get(mid) == num)
                return mid;
            if (item.get(mid) < num)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
    private static void displayMainMenu() {
        System.out.print("Please Enter:\n" +
                "1. Add Item\n" +
                "2. Search for Item\n" +
                "3. Display List\n" +
                "4. Exit\n");
    }
}