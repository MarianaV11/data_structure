public class OrderedDynamicList <T> {
    Node<T> first;
    Node<T> last;
    int count;

    public OrderedDynamicList() {
        first = null;
        last = null;
        count = 0;
    }

    public void add(T element) {
        Node<T> newElement = new Node(element);

        Node<T> aux = first;
        Node<T> previous = null;

       if (first == null) {
           first = newElement;
           last = newElement;
       } else {
           if (newElement.data instanceof Integer && aux.data instanceof Integer) {
               while (aux != null && ((Integer) newElement.data).compareTo((Integer) aux.data) > 0) {
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
           if (newElement.data instanceof String && aux.data instanceof String) {
               while (aux != null && ((String) newElement.data).compareTo((String) aux.data) > 0) {
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

           if (newElement.data instanceof Double && aux.data instanceof Double) {
               while (aux != null && ((Double) newElement.data).compareTo((Double) aux.data) > 0) {
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

           if (newElement.data instanceof Float && aux.data instanceof Float) {
               while (aux != null && ((Float) newElement.data).compareTo((Float) aux.data) > 0) {
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

           if (newElement.data instanceof Character && aux.data instanceof Character) {
               while (aux != null && ((Character) newElement.data).compareTo((Character) aux.data) > 0) {
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

           if (newElement.data instanceof Boolean && aux.data instanceof Boolean) {
               while (aux != null && ((Boolean) newElement.data).compareTo((Boolean) aux.data) > 0) {
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
        Node<T> aux = first;
        for(int i = 0; i < count; i++) {
            if (aux.data.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public void remove(Object element) {

    }

    public void removeAt(int position) {

    }

    public Object get(int index) {
        return null;
    }

    public int indexOf(Object element) {
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
