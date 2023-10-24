package Queue;
import Node.Node;
public class DinamicQueue {
    Node first;
    Node last;
    int count;
    public DinamicQueue() {
        count = 0;
        first = null;
        last = null;
    }

    public void enqueue(Object element) {
        Node newElement = new Node(element);
        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            last.next = newElement;
            newElement.previous = last;
            last = newElement;
        }
        count++;
    }

    public int size() {
        return count;
    }

    public void clear() {
        first = null;
    }

    public boolean contains(Object element) {
        Node aux = first;
        while (aux != null) {
            if (aux.data.equals(element))
                return true;
            aux = aux.next;
        }
        return false;
    }

    public void dequeue() {
        first.next.previous = null;
        first = first.next;
        count--;
    }

    public void dequeue(Object element) {
        Node aux = first;

        while (aux != null) {
            if (aux.data.equals(element)) {
                if (aux.equals(first)) {
                    first = aux.next;
                } else if (aux.equals(last)) {
                    last = last.previous;
                    last.next = null;
                } else {
                    aux.previous.next = aux.next;
                    aux.next.previous = aux.previous;
                }
                count--;
                break;
            } else {
                aux = aux.next;
            }
        }
    }
    public void firstToLastQueue() {
        enqueue(first.data);
        dequeue();
        count++;
    }

    public int indexOf(Object element) {
        Node aux = first;
        for (int i = 0; i <= count; i++) {
            if (aux.data.equals(element))
                return i;
            aux = aux.next;
        }
        return -1;
    }

    public Object front() {
        count--;
        return first.data;
    }

    @Override
    public String toString() {
        String str = "";
        Node aux = first;

        while (aux != null) {
            if(aux == last) {
                str += last.data;
                break;
            }
            str += aux.data + ", ";
            aux = aux.next;
        }
        return str;
    }
}
