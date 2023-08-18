import java.util.ArrayList;

public class GenericsDemo {

    public static void main(String[] args) {
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());

        double total = totalArea(circles);
    }


    public static <E> void printArray(E[] data) {
        for (E item: data) {
            System.out.printf("%s ", item);
        }
        System.out.println();
    }

    public static <T extends GeometricObject> double totalArea(ArrayList<T> objects) {
        double total = 0;
        for (T item: objects) {
            total += item.getArea();
        }
        return total;
    }


    class GeometricObject {
        public GeometricObject() {

        }
    }

    class Circle extends GeometricObject {
        public Circle() {

        }

        public int getArea() {

        }
    }



}
