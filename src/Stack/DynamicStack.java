package Stack;

import Node.Node;

public class DynamicStack <T> {
    Node top;
    int count;

    public DynamicStack() {
        top = null;
    }

    public void push(T element) {
        Node newElement = new Node(element);

        if (top == null) {
            top = newElement;
        } else {
            top.next = newElement;
            newElement.previous = top;
            top = newElement;
        }
        count++;
    }

    public int size() {
        return count;
    }

    public void clear() {
        top = null;
        count = 0;
    }

    public boolean contains(T element) {
        Node aux = top;

        while (aux != null) {
            if (aux.data.equals(element))
                return true;
            aux = aux.previous;
        }
        return false;
    }

    public Object pop() {
        if (top.next == null && top.previous == null) {
            Node aux = top;
            top = null;
            count--;
            return aux.data;
        } else {
            top = top.previous;
            top.next = null;
            count--;
        }
        return top.data;
    }

    public Object peek() {
        return top.data;
    }

    public int indexOf(T element) {
        Node aux = top;
        for (int i = 0; i <= count; i++) {
            if (aux.data.equals(element))
                return i;
            aux = aux.previous;
        }
        return -1;
    }

    @Override
    public String toString() {
        Node aux = top;
        String str = aux.data + "";

        aux = aux.previous;
        while (aux != null) {
            str += aux.data;
            aux = aux.previous;
        }
        return str + "";
    }
}
