package Stack;

public class StaticStack {
    Object []v;
    int top;
    public StaticStack(int capacity) {
        v = new Object[capacity];
        top = 0;
    }

    public void push(Object element) {
        v[top] = element;
        top++;
    }

    public int size() {
        return top;
    }

    public void clear() {
        for (int i = 0; i < top; i++) {
            v[i] = 0;
        }
    }

    public boolean contains(Object element) {
        for (int i = 0; i < top; i++) {
            if (v[i].equals(element))
                return true;
        }
        return false;
    }

    public Object pop() {
        top--;
        return v[top];
    }

    public Object peek() {
        return v[top];
    }

    @Override
    public String toString() {
        String str = "[";

        for (int i = 0; i < top; i++)
            str += " " + v[i];

        return str + "]";
    }
}
