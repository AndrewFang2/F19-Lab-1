import java.util.ArrayList;
import java.util.Scanner;
/**
 * Create a space to store information and organize it
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-08-03
 */
public class CollegeRegistrar {
    private ArrayList<Trainee> trainees;
    String name;
    public CollegeRegistrar() {
        name = "Unknown";
        trainees = new ArrayList<>();
    }
    /**
     * print out the list of trainee
     * @return a lise of trainee
     */
    public String toString() {
        System.out.println("College Registrar Information:\n" +
                "Name: " + name + "\n" +
                "Trainee List:");
        bubble();
        StringBuilder str = new StringBuilder();
        for (Trainee item : this.trainees) {
            if (item != null) {
                str.append(item.toString()).append("\n");
            }
        }
        return str.toString();
    }
    /**
     * add a trainee
     * @param scanner ask for the scanner you are using
     */
    public void addTrainee(Scanner scanner) {
        Trainee trainee = new Trainee();
        trainee.addTrainee();
        trainees.add(trainee);
    }
    /**
     * changes the name of the college
     */
    public void collegeName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter the College Registrar's Name: ");
        name = scanner.nextLine();
    }
    /**
     * searches for the specific trainee you want
     * @param scanner ask for the scanner you are using
     */
    public void searchForTrainee(Scanner scanner){
        boolean valid = false;
        int traineeNumber = 0;
        Trainee trainee = new Trainee();
        do {
            System.out.print("Please Enter the Trainee Number to Search for: ");
            if (scanner.hasNextInt()) {
                traineeNumber = scanner.nextInt();
                valid = true;
            } else {
                System.out.println("Incorrect format");
                scanner.next();
            }
        }while(!valid);
       for(int i = 0; i < this.trainees.size(); i++) {
           if(trainees.get(i)!= null) {
               if(trainees.get(i).getTraineeNumber() == traineeNumber){
                   System.out.println("Trainee found at index " + i);
                   System.out.println(trainees.get(i));
                   return;
               }
           }
       }
       System.out.println("Trainee not found in College Registrar");
   }
    /**
     * Sort the list with bubble sort
     */
    private void bubble() {
        Trainee temp;
        if (trainees.size()>1){
            for (int x=0; x<trainees.size(); x++){
                for (int i=0; i < trainees.size() - 1; i++)
                    if (trainees.get(i).getTraineeNumber() > trainees.get(i+1).getTraineeNumber()){
                        temp = trainees.get(i);
                        trainees.set(i,trainees.get(i+1) );
                        trainees.set(i+1, temp);
                    }
            }
        }
    }
}
