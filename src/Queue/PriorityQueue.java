package Queue;

import Node.Node;

public class PriorityQueue {
    Node first;
    Node last;
    int count;

    public PriorityQueue() {
        count = 0;
        first = null;
        last = null;
    }

    public void enqueue(Object element, int priority) {
        Node newElement = new Node(element, priority);
        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            if(newElement.priority < first.priority) {
                newElement.next = first;
                first.previous = newElement;
                first = newElement;
            } else if(newElement.priority >= last.priority) {
                last.next = newElement;
                newElement.previous = last;
                last = newElement;
            } else {
                Node aux = first;
                while (aux != null && newElement.priority >= aux.priority) {
                    aux = aux.next;
                }
                newElement.previous = aux.previous;
                aux.previous.next = newElement;
                newElement.next = aux;
                aux.previous = newElement;
            }
        }
        count++;
    }

    public int size() {
        return count;
    }

    public void clear() {
        first = null;
    }

    public void sort(Object data) {
        Node auxFirst = first;
        Node auxLast = last;

        while(auxFirst != null) {
            while(auxLast != null) {

            }
            auxLast = last;
            auxFirst = auxFirst.next;
        }
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
        String str = "[";
        Node aux = first;

        while (aux != null) {
            str += " " + aux.data;
            aux = aux.next;
        }
        return str + " ]";
    }
}
