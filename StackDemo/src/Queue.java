public class Queue<E> {

    private class QueueNode<E> {
        public E value;
        public QueueNode<E> next;
        public QueueNode<E> previous;
        public QueueNode(E value) { this.value = value; }

    }

    private QueueNode<E> first;

    private QueueNode<E> last;

    private int size;

    public boolean isEmpty() { return first == null; }

    public int getSize() { return this.size; }

    public void push(E value) {

        if (this.first == null) {
            first = new QueueNode<>(value);
            last = first;
        }
        else {
            QueueNode<E> newLast = new QueueNode<>(value);
            newLast.next = last;
            last.previous = newLast;
            last = newLast;
        }

        this.size ++;

    }

    public E pop() {

        QueueNode<E> previousFirst = first;

        if (getSize() > 1) {

            first = first.previous;
            first.next = null;

        }
        else {

            first = null;
            last = null;

        }

        this.size --;
        return previousFirst.value;


    }



}