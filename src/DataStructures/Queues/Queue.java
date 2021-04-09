package DataStructures.Queues;

public interface Queue<T> {

    void enqueue(T t) throws EmptyQueueException;
    T dequeue() throws EmptyQueueException;
    int size();
    boolean isEmpty();
}
