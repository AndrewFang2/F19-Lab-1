import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Andrew Fang
 * Student Number:  040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */

public class Lab1 {
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        Number numbers = new Number();
        PrintWriter printWriter = null;
        String choice = "";
        do {
            displayMainMenu();
            choice = keyboard.next();
            while(choice.equals(null) || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("8") && !choice.equals("9")) {
                System.out.println("try again ");
                choice = keyboard.nextLine();
                continue;
            }

            if(choice.equals ("1")) {
                numbers = new Number();
            } else if (choice.equals ("2")) {
                System.out.println("Enter new size of array: ");
                int size = keyboard.nextInt();
                numbers = new Number(size);
            } else if (choice.equals ("3")) {
                numbers.addValue(keyboard);
            } else if (choice.equals ("4")) {
                System.out.println(numbers.toString());
            } else if (choice.equals ("5")) {
                numbers.displayAvg();
                System.out.println();
            } else if (choice.equals ("6")) {
                System.out.println("Enter new size of array: ");
                int size = keyboard.nextInt();
                numbers = new Number(size);
                for(int i = 0; i < size; i++) {
                    numbers.addValue(keyboard);
                }
            } else if (choice.equals ("7")) {
                System.out.println("Name of the file to save to: ");
                String filename = keyboard.next();
                try {
                    printWriter = new PrintWriter("C:\\temp2020\\"+ filename);
                    numbers.print(printWriter);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (choice.equals ("8")) {
                System.out.println("Name of the file to save to: ");
                String filename = keyboard.next();
                try {
                    printWriter = new PrintWriter("C:\\temp2020\\"+ filename);
                    numbers.print(printWriter);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                continue;
            }
        }while(choice.equals ("1") || choice.equals ("2") || choice.equals ("3") || choice.equals ("4") || choice.equals ("5") || choice.equals ("6") || choice.equals ("7") || choice.equals ("8"));
        System.out.println("Exiting...");
        printWriter.close();
    }

    private static void displayMainMenu()  {
        System.out.print("Please select one of the following:\n" +
                "1: Initialize a default array\n" +
                "2: To specify the max size of the array\n" +
                "3: Add value to the array\n" +
                "4: Display values in the array\n" +
                "5: Display the average of the values\n" +
                "6: Enter multiple values\n" +
                "7: Read values from file\n" +
                "8: Save values to file\n" +
                "9: To Exit\n" +
                "> ");
    }

}