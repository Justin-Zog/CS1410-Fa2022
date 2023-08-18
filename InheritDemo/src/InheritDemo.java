import org.w3c.dom.css.Rect;

public class InheritDemo {
    public static void main(String[] args) {

        Circle c1 = new Circle(4, "blue", true);
        Circle c2 = new Circle(6, "green", false);
        Rectangle r1 = new Rectangle(3, 5, "red", true);
        Rectangle r2 = new Rectangle(7, 2, "yellow", false);

        report(c1);
        report(c2);
        report(r1);
        report(r2);

    }


    public static void report(Circle c) {
        System.out.println("--- Circle Report ---");
        System.out.printf("\tColor: %s\n", c.getColor());
        System.out.printf("\tFilled: %b\n", c.isFilled());

        System.out.printf("\tRadius %.2f\n", c.getRadius());
        System.out.printf("\tArea %.2f\n", c.getArea());
    }

    public static void report(Rectangle r) {
        System.out.println("--- Rectangle Report ---");
        System.out.printf("\tColor: %s\n", r.getColor());
        System.out.printf("\tFilled: %b\n", r.isFilled());

        System.out.printf("\tLength %.2f\n", r.getLength());
        System.out.printf("\tWidth %.2f\n", r.getWidth());
        System.out.printf("\tArea %.2f\n", r.getArea());
        System.out.printf("\tPerimeter %.2f\n", r.getPerimeter());
    }
}