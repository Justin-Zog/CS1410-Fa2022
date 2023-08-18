// Justin Herzog A02306067

import java.util.Scanner;
import java.lang.Math;

public class Pyramid1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("How many lines do you want the pyramid to have? ");

        int lines = input.nextInt();

        int columns = ((lines * 2) - 1);
        int bricksInRow = 1;

        // Loop that prints Pyramid. i can represent rows
        for (int i = 1; i <= lines; i++) {

            // Resets the spaceTracker
            String spaceTracker = (" ".repeat((int)Math.log10(lines) + 2));

            // Make a boolean that keeps track if the numbers flipped
            boolean hasFlipped = false;
            // Finds how many spaces to print before and after
            int spaceCount = (columns - bricksInRow);
            // Prints spaces until a "brick" is hit
            System.out.print(spaceTracker.repeat(spaceCount/2));

            // Loop that prints the "bricks"
            for (int j = 0; (j + i) <= (bricksInRow + 1); j++) {

                // Prints the numbers in descending then ascending order
                if (!hasFlipped) {
                    // Gets the correct spacing
                    spaceTracker = (" ".repeat((((int)Math.log10(lines) + 1)) - ((int)Math.log10(i - j))));
                    System.out.print(spaceTracker + (i - j));

                    if (i - j == 1) {
                        j = 1;
                        hasFlipped = true;
                    }
                }
                else {
                    // Gets the correct spacing
                    spaceTracker = (" ".repeat((((int)Math.log10(lines) + 1)) - ((int)Math.log10(j))));
                    System.out.print(spaceTracker + j);

                }

            }

            // Prints the spaces after the "bricks" and makes a newline.
            // Resets the spaceTracker
            spaceTracker = (" ".repeat((int)Math.log10(lines) + 2));
            System.out.print((spaceTracker).repeat(spaceCount/2));
            System.out.println();
            // Sets new brick count
            bricksInRow += 2;

        }

    }

}
