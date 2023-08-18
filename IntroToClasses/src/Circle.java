public class Circle {

    private double radius;
    // The static means that when the program starts, this data field exists even though no circle objects are created.
    private static int numberValidCirclesCreated = 0;

    public Circle(double newRadius) {
        numberValidCirclesCreated++;
        setRadius(newRadius);
    }

    public static int getNumberCreated() {
        return numberValidCirclesCreated;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
        else {
            this.radius = 1;
        }
    }
}
