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
            String word = "";
            do {
                System.out.print("Please enter a palindrome or exit to terminate the program: ");
                word = scanner.next();
                if(word.equals("exit")){}
                else{
                    if (isPalindrome(word))
                        System.out.println("The word " + word + " IS a palindrome");
                    else
                        System.out.println("The word " + word + " IS NOT a palindrome");
                }
            }while(!word.equals("exit"));
        }
/**This uses recursion to determine if it is a palindrome and would return a boolean once it is determined*/
    public static boolean isPalindrome(String s)
    {
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1, s.length()-1));
        return false;
    }
}
