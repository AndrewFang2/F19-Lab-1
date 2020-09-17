import java.util.ArrayList;
import java.util.Scanner;
/**
 * This a code to organize data
 * @author Andrew Fang
 * @StudentNumber: 040974861
 * @version 2020-06-17
 */
public class main {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> dataitems= new ArrayList<String>(100);
        for(int i=1;i<=100;++i) dataitems.add("");
        String choice = "";
        do {
            displayMainMenu();
            choice = keyboard.next();
            while (choice == null || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                choice = keyboard.nextLine();
                if (choice == null || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                    System.out.println("try again ");
                }
            }
            switch (choice) {
                case "1":
                    System.out.println("Enter your string :");
                    String s=scanner.next();
                    int a,b=0;
                    a = s.charAt(0);
                    if(s.length()>=2)
                        b = s.charAt(1);
                    int index = (a+b)%100;
                    if(dataitems.get(index).equals(""))
                        dataitems.add(index,s);
                    else
                    {
                        int f=1;
                        for(int i=index;i<=99;++i)
                        {
                            if(dataitems.get(i).equals(""))
                            {
                                dataitems.add(i,s);
                                f=0;
                                break;
                            }
                        }
                        if(f==1)
                            System.out.println("String can't be added");
                    }
                    break;
                case "2":
                    System.out.println("Enter String to be searched");
                    String s1=scanner.next();
                    int a1,b1=0;
                    a1= s1.charAt(0);
                    if(s1.length()>=2)
                        b1= s1.charAt(1);
                    int index1=(a1+b1)%100;
                    if(s1.equals(dataitems.get(index1)))
                        System.out.println("String found at index "+index1+".");
                    else
                    {
                        int f1=1;
                        for(int i=index1;i<=99;++i)
                        {
                            if(s1.equals(dataitems.get(i)))
                            {
                                System.out.println("String found at index "+index1+".");
                                f1=0;
                                break;
                            }
                        }
                        if(f1==1)
                            System.out.println("String not found.");
                    }
                    break;
                default:
            }
        }while(choice.equals ("1") || choice.equals ("2"));
        System.out.println("Exiting...");
    }
    private static void displayMainMenu() {
        System.out.print("1: Enter a String\n" +
                "2: Search for a String\n" +
                "3: To Exit\n" +
                 "> ");
            }
}
