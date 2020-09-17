import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name:Andrew Fang
 * Student Number:040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @author/Professor James Mwangi PhD.
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 * @author Andrew Fang
 */
public class Lab1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int size;
        int choice = 0;
        Number numbers=new Number();
        Scanner choi = new Scanner(System.in);
        do {
            displayMainMenu();

            choice = choi.nextInt();
            if (choice == 1) {
                numbers = new Number();
            } else if (choice == 2) {
                System.out.print("Enter new size of array : ");
                size = choi.nextInt();
                numbers = new Number(size);
            } else if (choice == 3) {
                numbers.addValue(choi);
            } else if (choice == 4) {
                System.out.println(numbers.toString());
            } else if (choice == 5) {
                numbers.calcAverage();
                numbers.disAverage();
            } else if (choice == 6) {
                System.out.print("Exiting...");
            } else {
                System.out.print("try again");
            }
        }while(choice!=6);
    }

    public static void displayMainMenu() {
        System.out.print("\nPlease select one of the following:\n" +
                "1: Initialize a default array\n" +
                "2: To specify the max size of the array\n" +
                "3: Add value to the array\n" +
                "4: Display values in the array\n" +
                "5: Display the average of the values\n" +
                "6: To Exit\n" +
                "> ");
    }
}