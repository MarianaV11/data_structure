package List;

import Node.Node;

public class OrderedDynamicList <T> {
    Node first;
    Node last;
    int count;

    public OrderedDynamicList() {
        first = null;
        last = null;
        count = 0;
    }

    public void add(T element) {
        Node newElement = new Node(element);

        Node aux = first;
        Node previous = null;
       if (first == null) {
           first = newElement;
           last = newElement;
       } else {
           while (aux != null && newElement.compareTo(aux) > 0) {
               previous = aux;
               aux = aux.next;
           }

           if (previous == null) {
               newElement.next = first;
               first = newElement;
           } else if (aux == null) {
               last.next = newElement;
               last = newElement;
           } else {
               previous.next = newElement;
               newElement.next = aux;
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

    public boolean contains(Object element) {
        Node aux = first;
        for(int i = 0; i < count; i++) {
            if (aux.data.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public void remove(Object element) {
        Node aux = first;
        Node previous = null;

        while (aux != null) {
            if (aux.data.equals(element)) {
                if (first.data.equals(element)) {
                    first = aux.next;
                    aux = first;
                } else if (aux.data.equals(last)) {
                    previous.next = null;
                    last = previous;
                    aux = null;
                } else {
                    previous.next = aux.next;
                }
                count--;
            }
            previous = aux;
            aux = aux.next;
        }
    }

    public void removeAt(int position) {
        Node aux = first;
        Node previous = null;

        if (position == 0) {
            aux = first.next;
            first = aux;
        } else if (position == size() - 1) {
            for (int i = 0; i < size() - 2; i++) {
                aux = aux.next;
            }
            last = aux;
            aux.next = null;
        } else  {
            for (int i = 0; i < position; i++) {
                previous = aux;
                aux = aux.next;
            }
            previous.next = aux.next;
        }
        count--;
    }

    public Object get(int index) {
        Node aux = first;

        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }

    public int indexOf(Object element) {
        Node aux = first;

        for (int i = 0; i < count; i++) {
            if (aux.data.equals(element)) {
                return i;
            }
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
