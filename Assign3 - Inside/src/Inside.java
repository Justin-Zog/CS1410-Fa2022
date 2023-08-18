/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = { 1, 2, 3, 4 };
        double[] ptY = { 1, 2, 3, 4 };
        double[] circleX = { 0, 5 };
        double[] circleY = { 0, 5 };
        double[] circleRadius = { 3, 3 };
        double[] rectLeft = { -2.5, -2.5 };
        double[] rectTop = { 2.5, 5.0 };
        double[] rectWidth = { 6.0, 5.0 };
        double[] rectHeight = { 5.0, 2.5 };

        // Loop over the circles, then the points and report on each.
        System.out.println("--- Report of Points and Circles ---");
        // Loops through the circles
        for (int i = 0; i < circleX.length; i++) {
            // Loops through all the points for each circle
            for (int j = 0; j < ptX.length; j++) {
                if (isPointInsideCircle(ptX[j], ptY[j], circleX[i], circleY[i], circleRadius[i])) {
                    System.out.println();
                    reportPoint(ptX[j], ptY[j]);
                    System.out.print(" is inside ");
                    reportCircle(circleX[i], circleY[i], circleRadius[i]);
                }
                else {
                    System.out.println();
                    reportPoint(ptX[j], ptY[j]);
                    System.out.print(" is outside ");
                    reportCircle(circleX[i], circleY[i], circleRadius[i]);
                }
            }
        }
        // Loop over the rectangles, then the points, reporting on each.
        // Idk why I need to do \n twice, but there is no newline if I only do one... Could just be a glitch with intelliJ
        System.out.println("\n\n--- Report of Points and Rectangles ---");
        // Loops through the rectangles
        for (int i = 0; i < rectTop.length; i++) {
            // Loops through all the points for each rectangle
            for (int j = 0; j < ptX.length; j++) {
                if (isPointInsideRectangle(ptX[j], ptY[j], rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i])) {
                    System.out.println();
                    reportPoint(ptX[j], ptY[j]);
                    System.out.print(" is inside ");
                    reportRectangle(rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                }
                else {
                    System.out.println();
                    reportPoint(ptX[j], ptY[j]);
                    System.out.print(" is outside ");
                    reportRectangle(rectLeft[i], rectTop[i], rectWidth[i], rectHeight[i]);
                }
            }
        }
    }

    // Prints the details for a single point.  For example, it would print, without a newline: Point(1.0, 1.0)
    public static void reportPoint(double x, double y) {
        System.out.print("Point(" + x + ", " + y + ")");
    }

    // Prints the details for a single circle.  For example, it would print, without a newline: Circle(0.0, 0.0) Radius: 3.0
    public static void reportCircle(double x, double y, double r) {
        System.out.print("Circle(" + x + ", " + y + ") Radius: " + r);
    }

    // Prints the details for a single rectangle. (left, right, top, bottom values)
    public static void reportRectangle(double left, double top, double width, double height) {
        System.out.print("Rectangle(" + left + ", " + (left + width) + ", " + top + ", " + (top - height) + ")");
    }

    // Tests if a point is inside a circle. Nothing is printed to the console in the function. If on the edge of a circle it is counted as inside.
    public static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        // Returns the result of the boolean operation below. (True if the point is in the circle and false otherwise)
        return (((circleX - ptX) * (circleX - ptX)) + ((circleY - ptY) * (circleY - ptY))) <= (circleRadius * circleRadius);
    }

    // Tests if a point is inside a rectangle. Nothing is printed to the console. A point on the edge is considered in the rectangle.
    public static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        // Returns the result of the boolean operation below. (True if the point is in the rectangle and false otherwise)
        return ((ptX >= rLeft) && (ptX <= (rLeft + rWidth)) && (ptY <= rTop) && (ptY >= (rTop - rHeight)));
    }

}
