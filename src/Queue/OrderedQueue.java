package Queue;
import Node.Node;
public class OrderedQueue {
    Node first;
    Node last;
    int count;
    public OrderedQueue() {
        first = null;
        last = null;
    }
    public void enqueue (Object element, int priority) {
        Node newElement = new Node(element, priority);
        Node aux = first;

        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            while (aux != null && newElement.priority >= aux.priority) {
                aux = aux.next;
            }

            if (aux == first) {
                newElement.next = first;
                first.previous = newElement;
                first = newElement;
            } else if (aux == null) {
                newElement.previous = last;
                last.next = newElement;
                last = newElement;
            } else {
                aux = first;
                newElement.next = aux;
                aux.previous.next = newElement;
                newElement.previous = aux.previous;
                aux.previous = newElement;
            }
        }
        count++;
    }
}
