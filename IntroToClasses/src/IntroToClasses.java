public class IntroToClasses {
    public static void main(String[] args) {

        demoArrayOfObjects();

        System.out.printf("This many circles have been created: %d\n", Circle.getNumberCreated());

        // Makes a new circle object with the name c1. It has the default radius of 1.
        Circle c1 = new Circle(1);
        // Makes a new circle object with the name c2. It has a radius of 6.
        Circle c2 = new Circle(6);
        // You can also make a circle like this: generally you do not want to do this though.
        Circle c3; // The value of c3 right now is null
        c3 = new Circle(2.22);
        // null is its own value type in java.
        Circle c4;
        c4 = null;
        // Having a circle equal a null value will cause errors when trying to run functions of the Circle class.

        // We used c4.getNumberCreated() to prove that because numberCreated is static, there is only one instance of it.
        // In other words it is the same value for all circle objects, even if the object is null.
        System.out.printf("This many circles have been created: %d\n", c4.getNumberCreated());

        System.out.printf("The area of a circle with the radius %.2f is %.4f\n",
                c1.getRadius(),
                c1.getArea());

        System.out.printf("The area of a circle with the radius %.2f is %.4f\n",
                c2.getRadius(),
                c2.getArea());

        System.out.printf("The area of a circle with the radius %.2f is %.4f\n",
                c3.getRadius(),
                c3.getArea());

        // If we assign c1 to c2, we just have a circle object with 2 'names'
        c1 = c2; //c1 and c2 both reference one circle object with a radius of 6
        System.out.printf("The area of a circle with the radius %.2f is %.4f\n",
                c1.getRadius(),
                c1.getArea());
        System.out.printf("The area of a circle with the radius %.2f is %.4f\n",
                c2.getRadius(),
                c2.getArea());

    }

    public static void demoArrayOfObjects() {
        // Initializes an array of ten Null objects
        int[] myData = new int[10];

        // Initializes an array of ten Null Circles
        Circle[] myCircles = new Circle[10];

        for (int i = 0; i < myCircles.length; i++) {
            myCircles[i] = new Circle(i);
            System.out.println(myCircles[i].getRadius());
        }

    }

}
