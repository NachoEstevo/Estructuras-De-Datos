package DataStructures.Queues;

public class EmptyQueueException extends Exception {
    public EmptyQueueException(){
        super("The queue is empty. Try adding elements before a dequeue");
    }
}
