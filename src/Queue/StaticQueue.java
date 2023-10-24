package Queue;

public class StaticQueue {
    Object []v;
    int first = 0;
    int last = -1;
    public StaticQueue(int capacity) {
        v = new Object[capacity];
    }

    public void enqueue(Object element) {
        v[++last] = element;
    }

    public int size() {
        return last - first + 1;
    }

    public Object get(int indice) {
        return v[indice];
    }

    public void clear() {
        for (int i = 0; i < last; i++) {
            v[i] = 0;
        }
        last = -1;
        first = 0;
    }

    public boolean contains(Object element) {
        for (int i = 0; i < last; i++) {
            if (v[i].equals(element))
                return true;
        }
        return false;
    }

    public void dequeue() throws Exception {
        try {
            first++;
        } catch (Exception e) {
            if (size() == 0)
                throw new Exception("Queue don't have any element inside");
        }
    }

    public int indexOf(Object element) {
        for (int i = first; i < last + 1; i++) {
            if (v[i] == element)
                return i;
        }

        return -1;
    }

    public Object front() {
        return v[first];
    }

    @Override
    public String toString() {
        String str = "[";

        for (int i = first; i < last + 1; i++)
            str += " " + v[i];

        return str + " ]";
    }
}
