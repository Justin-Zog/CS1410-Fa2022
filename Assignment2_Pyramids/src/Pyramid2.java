// Justin Herzog A02306067

import java.util.Scanner;
import java.lang.Math;

public class Pyramid2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("How many lines do you want the pyramid to have? ");

        int lines = input.nextInt();

        int columns = ((lines * 2) - 1);
        int bricksInRow = 1;

        // Loop that prints Pyramid. i can represent rows
        for (int i = 1; i <= lines; i++) {

            // Resets the spaceTracker
            String spaceTracker = (" ".repeat((int)Math.log10((long)Math.pow(2, lines)) + 2));
            // A variable that helps match up the exponents on the flip side.
            int x = 0;
            // Make a boolean that keeps track if the numbers flipped
            boolean hasFlipped = false;
            // Finds how many spaces to print before and after
            int spaceCount = (columns - bricksInRow);
            // Prints spaces until a "brick" is hit
            System.out.print(spaceTracker.repeat(spaceCount/2));

            // Loop that prints the "bricks"
            for (int j = 0; j < bricksInRow; j++) {

                // Prints the numbers in descending then ascending order
                if (!hasFlipped) {
                    // Sets the spacing for the individual number each time
                    spaceTracker = (" ".repeat(((int)Math.log10((long)Math.pow(2, lines)) + 2) - ((int)Math.log10((long)Math.pow(2, j)) + 1)));

                    System.out.print(spaceTracker + ((long)(Math.pow(2, j))));

                    if (i - j == 1) {
                        x = (j - 1);
                        hasFlipped = true;
                    }

                }
                else {
                    // Sets the spacing for the individual number each time
                    // Sets the spacing for the individual number each time
                    spaceTracker = (" ".repeat(((int)Math.log10((long)Math.pow(2, lines)) + 2) - ((int)Math.log10((long)Math.pow(2, x)) + 1)));
                    System.out.print(spaceTracker + ((long)(Math.pow(2, x))));
                    x--;
                }

            }

            // Prints the spaces after the "bricks" and makes a newline.
            spaceTracker = (" ".repeat((int)Math.log10((long)Math.pow(2, lines)) + 2));
            System.out.print(spaceTracker.repeat(spaceCount/2));
            System.out.println();
            // Sets new brick count
            bricksInRow += 2;

        }

    }

}

