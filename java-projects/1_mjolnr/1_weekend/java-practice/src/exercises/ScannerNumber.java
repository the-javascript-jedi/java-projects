package exercises;

import java.util.Scanner;

public class ScannerNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");  // prompt the user
        String name = sc.nextLine();            // read a line of text
        System.out.println("Hello, " + name + "!");
        System.out.print("Enter a number: ");
        int num = sc.nextInt();                 // reads an int this time
        System.out.println("Its square is: " + (num * num));
    }
}