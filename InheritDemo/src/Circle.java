// We want a circle to have an 'is a' relationship
// To do this we do the 'extends' 'class'
// Now this circle has a color and isFilled variable already.

public class Circle extends GeometricObject {

    private double radius;


    public Circle(double radius, String color, boolean filled) {
        // The code below does not work because color is a private variable.
        // this.color = color;
        // To overcome this we pretty much just put the same code as a function in the superclass.
        // setColor(color);
        // setFilled(filled);

        // The super has to be the first thing that we call.
        // You can also do this as a shortcut!
        super(transformColor(color), filled);
        this.radius = radius;

    }

    private static String transformColor(String color) {
        return "light " + color;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }


}
