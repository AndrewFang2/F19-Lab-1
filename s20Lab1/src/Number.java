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
public class Number {
    /**
     * Stores Float values.
     */
    private Float [] numbers;

    /**
     * Store the number of items currently in the array.
     */
    private int numItems;
    private int currentNumItem;
    /**
     * Default Constructor
     */
    public Number() {
    }

    /**
     * Constructor that initializes the numbers array.
     * @param size - Max size of the numbers array
     */
    public Number(int size) {
        numbers = new Float[size];
        numItems = size;
        currentNumItem = size;
    }

    /**
     * Adds a value in the array
     * @param keyboard - Scanner object to use for input
     */
    public void addValue(Scanner keyboard) {
        keyboard = new Scanner(System.in);
        System.out.print("Enter value: ");
        float number = keyboard.nextFloat();
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i]==null){
                numbers[i] = number;
                break;
            }
       }
        // TODO Write code here to add the values in the array
    }

    /**
     * Calculates the average of all the values in the numbers array.
     * @return float value that represents the average
     */
    public float calcAverage() {
        int num;
        int sum = 0;
        for (num = 0; num < numbers.length; num++){
            sum+=numbers[num];
        }
        // TODO Write code to return the average of the values in the array
        return sum/num;
    }
    public void disAverage() {
        try {
            if(numItems == 0) {
                System.out.print("Average is: " + 0.0);
            }
            else {
                System.out.println("Average is: " + calcAverage());
            }
        }catch(ArithmeticException e) {
            System.out.print("");
        }
    }

    @Override
    public String toString() {
        System.out.println("Numbers are: ");
        String str = "";
        for(int i = 0; i < numItems; i++) {
            str += numbers[i] + "\n";
        }
        // TODO Write code for an appropriate toString method
        return str;
    }
}