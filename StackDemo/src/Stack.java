public class Stack<E> {

    private class StackNode<E> {
        public E value;
        public StackNode<E> next;
        public StackNode(E value) {
            this.value = value;
        }
    }

    private StackNode<E> top;

    private int size;

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return this.size;
    }

    public void push(E value) {

        StackNode<E> newTop = new StackNode<>(value);
        newTop.next = top;
        top = newTop;

        this.size ++;

    }

    public E pop() {

        StackNode<E> previousTop = top;
        top = top.next;
        this.size --;
        return previousTop.value;

    }

    public E top() throws Exception {
        if (this.top == null) {
            throw new Exception("Empty Stack");
        }
        return this.top.value;
    }

}