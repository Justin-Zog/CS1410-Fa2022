// Justin Herzog A02306067
import java.util.Scanner;

public class ISBN {

    public static void main(String[] args) {

        // Create a Scanner that allows the user input
        Scanner input = new Scanner(System.in);
        // Ask the user for the first 9 digits of the ISBN
        System.out.print("Enter the first 9 digits of an ISBN: ");

        // Store the ISBN-9 given.
        int isbnNine = input.nextInt();
        // We need to find each of the d's now. (d1, d2, d3, etc.)
        int d1 = (isbnNine / 100_000_000);
        int d2 = ((isbnNine / 10_000_000) - (d1*10));
        int d3 = ((isbnNine / 1_000_000) - (((d1 * 10) + d2) * 10));
        int d4 = ((isbnNine / 100_000) - (((d1 * 100) + (d2 * 10) + d3) * 10));
        int d5 = ((isbnNine / 10_000) - (((d1 * 1_000) + (d2 * 100) + (d3 * 10) + d4) * 10));
        int d6 = ((isbnNine / 1_000) - (((d1 * 10_000) + (d2 * 1_000) + (d3 * 100) + (d4 * 10) + d5) * 10));
        int d7 = ((isbnNine / 100) - (((d1 * 100_000) + (d2 * 10_000) + (d3 * 1_000) + (d4 * 100) + (d5 * 10) + d6) * 10));
        int d8 = ((isbnNine / 10) - (((d1 * 1_000_000) + (d2 * 100_000) + (d3 * 10_000) + (d4 * 1_000) + (d5 * 100) + (d6 * 10) + d7) * 10 ));
        int d9 = ((isbnNine) - (((d1 * 10_000_000) + (d2 * 1_000_000) + (d3 * 100_000) + (d4 * 10_000) + (d5 * 1_000) + (d6 * 100) + (d7 * 10) + d8) * 10 ));
        int d10 = (((d1) + (d2*2) + (d3*3) + (d4*4) + (d5*5) + (d6*6) + (d7*7) + (d8*8) + (d9*9)) % 11);

        // Have the System output the 10-digit ISBN
        // If statement that make d10 "X" if it equals 10
        if (d10 != 10) {
            // I understand that I could just have it print ((isbnNine * 10) + d10) but I used all d* just to double-check.
            // That is of course unless isbnNine starts with a zero.
            System.out.println("The ISBN-10 number is: " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);
        } else {
            System.out.println("The ISBN-10 number is: " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + "X");
        }

    }

}
