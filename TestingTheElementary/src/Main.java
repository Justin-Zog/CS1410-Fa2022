import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        //Prompt User to enter a radius
        System.out.print("Enter a number for radius: ");
        //Step 1: Read in radius
        double radius = input.nextDouble();
        //Step 2: Compute area
        double area = radius * radius * Math.PI;
        //Step 3: Display the area
        System.out.println("The area for the circle of radius " + radius + " is " + area);
    }

}
