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
        Node<T> aNode = new Node<T>(newElement); //We create a new node containing the data to enqueue and pointing nowhere. Yet.
        aNode.next = null;
            if (!isEmpty()){
                back.next = aNode;
            }
            else{
                front = aNode;
            }
            back = aNode;
            size++;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (size != 0) {
            T toDequeue = (T) front.getData();
            front = front.next;
            size--;
            return toDequeue;
        }
        else{//Queue is empty cannot return a value
            throw new EmptyQueueException();
        }
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
