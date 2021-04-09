package DataStructures.Queues;

public class Node<T> {
    private T data;
    public Node<T> next;

    public Node(T element) {
        data = element;
        next = null;
    }

    public T getData() {return data;}

    public Node<T> getNext() { return next; }

}