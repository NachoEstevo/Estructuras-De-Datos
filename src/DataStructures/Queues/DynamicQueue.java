package DataStructures.Queues;

public class DynamicQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    public DynamicQueue(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T newElement) {
            Node<T> aux = new Node<T>(newElement, null);
            if(isEmpty()){
                front = aux;
            }
            else {
                back.next = aux;
            }
            back = aux;
            size++;
        }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T valueToReturn = front.getData();
        front = front.next;
        size--;
        return valueToReturn;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Node getFront(){
        return front;
    }
}
