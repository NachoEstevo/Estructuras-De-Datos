package DataStructures.Lists;

public class List<T> {

    private Nodo first;
    private Nodo last;
    private Nodo actual;
    private int size;

    public List() {
        first = new Nodo(); // Cabecera
        last = new Nodo(); // Centinela
        first.next = last;
        last.prev = first;
    }

    public void first() {
        actual = first.next;
    }

    public boolean previous() {
        if (actual != first.next) {
            actual = actual.prev;
            return true;
        }
        return false;
    }

    public boolean next() {
        if (actual != last.prev) {
            actual = actual.next;
            return true;
        }
        return false;
    }

    public void addBefore(T x) {
        Nodo p = new Nodo();
        p.element = x;
        if (isEmpty())
        { p.prev = first;
            p.next = last;
            first.next = p;
            last.prev = p;
        }
        else { p.prev = actual.prev;
            p.next = actual;
            actual.prev.next = p;
            actual.prev = p;
        }
        actual = p;
        size++;
    }

    public void addAfter(T x) { Nodo p = new Nodo();
        p.element = x;
        if (isEmpty())
        { p.prev = first;
            p.next = last;
            first.next = p;
            last.prev = p;
        }
        else { p.prev = actual;
            p.next = actual.next;
            actual.next.prev = p;
            actual.next = p;
        }
        actual = p;
        size++;
    }

    public void delete() {
        actual = actual.prev;
        actual.next.next.prev = actual;
        actual.next = actual.next.next;
        size--;
    }
    public boolean isEmpty() { return (size == 0);
    }
    public boolean belongs(T x) {
        if (!isEmpty()) {
            Nodo ouch = first.next;
            while(ouch.next != null) {
                if( ouch.element == x) {
                    return true;
                }
                ouch = ouch.next;
            }
            return false;
        }
        return false;
    }

    public T peekCurrent() {
        return (actual.element);
    }
    public int currentPosition() {
        Nodo ouch = first.next;
        int current = 1;
        while (ouch != actual)
        { current ++;
            ouch = ouch.next;
        }
        return current;
    }
    public int size(){
        return size;
    }


    @Override
    public String toString(){
        String result = "[";
        for (int i = 0; i < currentPosition(); i++) {
            previous();
        }
        for (int i = 0; i < size; i++) {
            result += peekCurrent();
            next();
        }
        return result;
    }

    private class Nodo {
        T element;
        Nodo prev;
        Nodo next;
    }
}
