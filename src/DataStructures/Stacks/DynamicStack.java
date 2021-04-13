package DataStructures.Stacks;

import DataStructures.Queues.Node;

public class DynamicStack<T> implements Stack<T>{
    private int size;
    private Node<T> top;

    public DynamicStack(){ size = 0;}

    @Override
    public void push(T newElement) {
        Node<T> aux = new Node<T>(newElement);
        aux.next = top;
        top = aux;
        size++;
    }

    @Override
    public void pop() throws EmptyStackException {
        if (top != null) {
            top = top.next;
            size--;
        }
       else {
            throw new EmptyStackException();
        }
    }

    @Override
    public T peek() throws EmptyStackException {
        if (size != 0) {
            return top.getData();
        } else {
            throw new EmptyStackException();
        }
    }

    @Override
    public boolean isEmpty() { return size == 0;}

    @Override
    public void empty() throws EmptyStackException {
        while (size != 0){
            this.pop();
        }
    }

    public int getSize() {
        return size;
    }
}
