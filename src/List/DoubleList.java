package List;

import Node.Node;

public class DoubleList <T> {
    Node first;
    Node last;

    int count;

    public DoubleList() {
        first = null;
        last = null;
    }

    public void addAtBeginning(T element) {
        Node newElement = new Node(element);

        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            newElement.next = first;
            first.previous = newElement;
            first = newElement;
        }
        count++;
    }

    public void add(T element) {
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

    public void add(int position, T element) {
        if (position == 0) {
            addAtBeginning(element);
        } else if (position == size() - 1) {
            add(element);
        } else {
            Node aux = first;
            Node newElement = new Node(element);
            for (int i = 0; i < position; i++) {
                aux = aux.next;
            }
            aux.previous.next = newElement;
            newElement.previous = aux.previous;
            newElement.next = aux;
            aux.previous = newElement;
        }
    }

    public int size() {
        return count;
    }

    public void clear() {
        first = null;
        count = 0;
    }

    public boolean contains(T element) {
        Node aux = first;

        for (int i = 0; i < count - 1; i++) {
            if (aux.data.equals(element))
                return true;
            aux = aux.next;
        }
        return false;
    }

    public void remove(T element) {
        Node aux = first;

        while (aux != null) {
            if (aux.data.equals(element)) {
                if (aux.equals(first)) {
                    first = aux.next;
                    aux = first;
                } else if (aux.equals(last)) {
                    last.previous.next = null;
                    last = last.previous;
                    aux = null;
                } else {
                    aux.previous.next = aux.next;
                    aux.next.previous = aux.previous;
                    aux = aux.next;
                }
                count--;
            } else {
                aux = aux.next;
            }
        }
    }

    public void removeAt(int position) {
        if (position == size() - 1) {
            last.previous.next = null;
            last = last.previous;
        } else if (position == 0) {
            first.next.previous = null;
            first = first.next;
        } else {
            Node aux = first;

            for (int i = 0; i < position; i++) {
                aux = aux.next;
            }

            aux.previous.next = aux.next;
            aux.next.previous = aux.previous;
        }
    }

    public Object get(int index) {
        if (index > count)
            return -1;

        Node aux = first;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }

    public int indexOf(Object element) {
        Node aux = first;

        for (int i = 0; i < count; i++) {
            if (aux.data.equals(element))
                return i;
            aux = aux.next;
        }
        return -1;
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
