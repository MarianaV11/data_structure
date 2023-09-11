public class Node <T> {
    public T data;
    public Node<T> next;
    public Node<T> previous;

    public Node(T dado) {
        this.data = dado;
        previous = null;
        next = null;
    }
}
