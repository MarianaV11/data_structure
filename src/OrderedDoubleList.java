public class OrderedDoubleList <T> {
    Node first;
    Node last;

    int count;

    public OrderedDoubleList() {
        first = null;
        last = null;
    }


    public void add(T element) {
        Node newElement = new Node(element);
        Node aux = first;

        if (first == null) {
            first = newElement;
            last = newElement;
        } else {
            while (aux != null && newElement.compareTo(aux) > 0) {
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
                newElement.next = aux;
                aux.previous.next = newElement;
                newElement.previous = aux.previous;
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
        count = 0;
    }

    public boolean contains(T element) {
        Node aux = first;

        for (int i = 0; i < count; i++) {
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
        Node aux = first;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }
        return aux.data;
    }

    public int indexOf(T element) {
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
        String str = "";
        Node aux = first;

        while (aux != null) {
            str += aux.data + " ";
            aux = aux.next;
        }
        return str;
    }
}
