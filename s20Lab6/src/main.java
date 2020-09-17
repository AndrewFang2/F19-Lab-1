import java.util.LinkedList;
import java.util.Scanner;
/**
 * This program to confirm if a string one input is a palindrome or not
 * @author Andrew Fang
 * @StudentNumber: 040974861
 * @version 2020-06-17
 */
public class main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[]args) {
        String expression = "";
        do {
            System.out.print("Enter an expression (or exit to terminate): ");
            expression = scanner.nextLine().trim();
            if(expression.equals("exit")){}
            else{
                if (expressionBalancer(expression))
                    System.out.println("The expression is balanced\n");
                else
                    System.out.println("The expression is NOT balanced\n");
            }
        }while(!expression.equals("exit"));
        System.out.println("Terminating....");
    }

    /**
     * check if it matches
     * @param c1 check if it is a ( or {
     * @param c2 check if it is a ) or }
     * @return check if equation inside the equation are balance
     */
    private static boolean Matcher(char c1, char c2){
        if (c1 == '(' && c2 == ')'){
            return true;
        }else if (c1 == '{' && c2 == '}'){
            return true;
        }else{
            return false;
        }
    }
    /**
     * check if the expression is balance
     * @param expression
     * @return true if the equation is balance
     */
    public static boolean expressionBalancer(String expression){
        LinkedList<String> bracket = new LinkedList<>();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '(' || expression.charAt(i) == '{'){
                bracket.addFirst(expression.charAt(i) + "");
                continue;
            }else if(expression.charAt(i) == ')' || expression.charAt(i) == '}'){
                if(bracket.isEmpty())
                    return false;
                else if(!Matcher(bracket.removeFirst().charAt(0), expression.charAt(i)))
                    return false;
            }
        }
        if(bracket.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
