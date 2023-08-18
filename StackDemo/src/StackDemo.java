public class StackDemo {
    public static void main(String[] args) {

        Queue<String> people = new Queue<>();

        people.push("Spencer");
        people.push("Emily");
        people.push("Justin");
        people.push("Ethan");

        System.out.println("--- Remove From Queue ---");
        while (!people.isEmpty()) {
            System.out.println("Popped the value " + people.pop());
        }



        Stack<String> cities = new Stack<>();

        cities.push("Paradise");
        cities.push("Wellsville");
        cities.push("Hyrum");
        cities.push("Nibley");
        cities.push("Logan");
        cities.push("Benson");
        cities.push("Amalga");
        cities.push("Newton");

        System.out.println("--- Remove From Stack ---");
        while (!cities.isEmpty()) {
            System.out.println("Popped the value: " + cities.pop());
        }

    }
}
