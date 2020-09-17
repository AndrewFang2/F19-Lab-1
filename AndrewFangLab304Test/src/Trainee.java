import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * declare all the values and set them into a value
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-08-03
 */
public class Trainee {
    int traineeNumber;
    String traineeName;
    float balance;
    /**
     * constructor
     */
    public Trainee() {
        traineeNumber = 0;
        traineeName = "";
        balance = 0;
    }
    /**
     * print out the look of each row of the list
     * @return the row of teach trainee
     */
    public String toString() {
        System.out.println("Trainee List: ");
        return ("Trainee #: " + traineeNumber + ", Name: " + traineeName + ", Balance: $" + balance);
    }
    /**
     * add a trainee
     */
    public void addTrainee() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        System.out.print("Please Enter the Trainee's Name: ");
        traineeName = scanner.nextLine();
        do{
            try {
                System.out.print("Please Enter the Trainee Number: ");
                traineeNumber = scanner.nextInt();
                if(traineeNumber > 0)
                    valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect format");
                scanner.next();
            }
        }while(!valid);
        boolean invalid = false;
        do{
            try {
                System.out.print("Please Enter the Trainee's Balance: ");
                balance = scanner.nextFloat();
                if(balance > 0)
                    invalid = true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect format");
                scanner.next();
            }
        }while(!invalid);
    }
    /**
     * get the traineeNumber
     * @return the trainee id returns
     */
    public int getTraineeNumber(){
        return traineeNumber;
    }
}