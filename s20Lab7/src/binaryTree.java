import java.util.Scanner;
/**
 * This is a code on binary tree and able to input data into it and print it out
 * @author Andrew Fang
 * @StudentNumber: 040974861
 * @version 2020-06-17
 */
public class binaryTree {
    private static Scanner keyboard = new Scanner(System.in);
    private Node root;
    binaryTree(){
        root = null;
    }
    /**
     * A class for the node
     */
    static class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
        public void displayData(){
            System.out.print(value + " ");
        }
    }
    /**
     * take the value and locate it in the node
     * @param i take in the value you entered
     */
    public void insert(int i){
        root = insert(root, i);
    }
    /**
     * ask fo what you would like to insert into the tree
     * @param node location of the tree
     * @param value check the value you entered
     * @return return the node
     */
    public Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        else if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }
    /**
     * This order the data for least to large
     * @param node ask for the tree you want to organize
     */
    public void order(Node node){ //change to inorder
        if(node != null){
            order(node.left);
            node.displayData();
            order(node.right);
        }
    }
    /**
     * This check the height of the tree
     * @param root ask for the tree you want to check
     * @return return the height of the tree
     */
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
    /**The part that run the program*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        binaryTree bt = new binaryTree();
        do {
            displayMainMenu();
            choice = keyboard.next();
            while (choice == null || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
                choice = keyboard.nextLine();
                if(choice == null || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")){
                    System.out.println("try again ");
                }
            }
            switch (choice) {
                case "1":
                    System.out.print("Enter an integer to add to the tree: ");
                    bt.insert(scanner.nextInt());
                    break;
                case "2":
                    System.out.println("Tree Traversal");
                    bt.order(bt.root);
                    System.out.println();
                    break;
                case "3":
                    System.out.println("Tree Height");
                    System.out.println(height(bt.root));

                    break;
                default:
            }
        }while(choice.equals ("1") || choice.equals ("2") || choice.equals ("3"));
        System.out.println("Exiting...");
    }
    /**the menu*/
    private static void displayMainMenu() {
        System.out.print("1: Add Value to Tree\n" +
                "2: Display Tree (In-Order Traversal)\n" +
                "3: Display Height\n" +
                "4: To Exit\n" +
                "> ");
    }
}