// Justin Herzog A02306067
import java.util.Scanner;
import java.lang.Math;


public class Quadratic {

    public static void main(String[] args) {

        // Creates a Scanner that allows user input
        Scanner input = new Scanner(System.in);
        // Prompt user to enter a, b and c.
        System.out.print("Enter a, b, c: ");
        // Read the input from the user
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        // Find the roots
        // I'll put some math here and evaluate the input from the user.
        double discriminant = (Math.pow(b,2) - 4 * a * c);
        double r1 = ((-b + Math.sqrt(discriminant)) / 2);
        double r2 = ((-b - Math.sqrt(discriminant)) / 2);

        // Tell the user the roots
        if (discriminant > 0) {
            System.out.println("There is two roots for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2);
        } else if (discriminant == 0) {
            System.out.println("There is one root for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + r1);
        } else {
            System.out.println("There are no real roots for the quadratic equation with these coefficients.");
        }

    }

}
