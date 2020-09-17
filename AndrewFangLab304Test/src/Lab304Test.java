import java.util.Scanner;
/**
 * This class contain the components to run the program and display it
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-08-03
 */
public class Lab304Test {
    public static void main(String[] args) {
        Trainee trainee = new Trainee();
        Scanner scanner = new Scanner(System.in);
        CollegeRegistrar collegeRegistrar = new CollegeRegistrar();
        String input;
        do {
                displayMenu();
                input = scanner.next();
            while(input == null || input.equals("") || input.equals("\t") || !input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5")){
            input = scanner.nextLine();
            if (input == null || input.equals("") || input.equals("\t") || !input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5")) {
                System.out.println("Unsupported choice");
                displayMenu();
            }
        }
            switch (input) {
                case "1":
                    collegeRegistrar.addTrainee(scanner);
                    break;
                case "2":
                    System.out.print(collegeRegistrar.toString());
                    break;
                case "3":
                    collegeRegistrar.collegeName();
                    break;
                case "4":
                    collegeRegistrar.searchForTrainee(scanner);
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
            }
        }while(!input.equals("5"));
    }
    /**
     * display the menu
     */
    public static void displayMenu() {
        System.out.print("Please select one of the following:\n" +
                "1: Add Trainee to College Registrar\n" +
                "2: Display Trainees in the Registrar\n" +
                "3: Set College Registrar Name\n" +
                "4: Search for a Trainee\n" +
                "5: Exit\n" +
                "Enter your Selection: ");
    }
}
