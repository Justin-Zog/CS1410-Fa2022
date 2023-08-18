public class LinkedListDemo {

    public static void main(String[] args) {

        demoBST();

    }

    public static void demoBST() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(9);
        bst.insert(18);
        bst.insert(8);
        bst.insert(20);
        bst.insert(3);
        bst.insert(5);
        bst.insert(4);
        bst.insert(25);
        bst.insert(16);
        bst.insert(17);

        bst.traverseInOrder();

        System.out.println("---");
        bst.remove(3);

        bst.traverseInOrder();

        System.out.println("---");
        bst.remove(17);

        bst.traverseInOrder();
    }

    public static void demoLinkedList() {
        LinkedList<String> cities = new LinkedList<>();

        cities.insert("Paradise");
        cities.insert("Hyrum");
        cities.insert("Nibley");
        cities.insert("Logan");
        cities.insert("Hyde Park");
        cities.insert("Smithfield");
        cities.insert("Amalga");

        cities.display();

        cities.remove("Amalga");

        cities.display();
    }
}
