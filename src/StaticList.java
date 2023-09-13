public class StaticList {
    Object []v;
    int count;
    public StaticList (int capacity) {
        v = new Object[capacity];
        count = 0;
    }

    public void add (Object element) {
        v[count] = element;
        count++;

    }

    public void add (int position, Object element) {
        for (int i = count; i < position; i++) {
            v[i] = v[i - 1];
        }
        v[position] = element;
        count++;
    }

    public int size () {
        return count;
    }

    public Object get (int indice) {
        return v[indice];
    }

    public void clear () {
        for (int i = 0; i < count; i++) {
            v[i] = 0;
        }
    }

    public boolean contains (Object element) {
        for (int i = 0; i < count; i++) {
            if (v[i].equals(element))
                return true;
        }
        return false;
    }

    public void remove (int indice) {
        for (int i = indice; i < count; i++) {
            v[i] = v[i + 1];
        }
        count--;
    }

    public void remove (Object element) {
        int position = indexOf(element);
        for (int i = position; i < count; i++) {
            v[i] = v[i + 1];
        }
        count--;
    }

    public int indexOf (Object element) {
        for (int i = 0; i < count; i++) {
            if (v[i] == element)
                return i;
        }

        return -1;
    }

    @Override
    public String toString () {
        String str = "[";

        for (int i = 0; i < count; i++)
            str += " " + v[i];

        return str + "]";
    }
}
