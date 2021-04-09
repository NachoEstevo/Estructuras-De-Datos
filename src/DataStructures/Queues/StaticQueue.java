package DataStructures.Queues;

public class StaticQueue<T> implements Queue<T>{
    private T[] queue;
    public int front;
    public int back;
    private int size, maxSize;

    public StaticQueue(){ new StaticQueue<T>(10);}

    public StaticQueue(int maxSize){ //First In First Out
        queue = (T[]) new Object[maxSize];
        size = 0;
        front = 0;
        back = 0;
        this.maxSize = maxSize;
    }

    @Override
    public void enqueue(T newElement) throws EmptyQueueException {
        if (back != maxSize){
            queue[back] = newElement;
            back++;
            size++;
        }
        else{
            resizeQueue();
            enqueue(newElement);
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (!isEmpty()) {
            T removed = queue[front];
            front++;
            size--;
            return removed;
        }
        else {
            throw new EmptyQueueException();
        }
    }

    @Override
    public int size() {return size;}

    public boolean isEmpty () {return size == 0;}

    private  void resizeQueue() throws EmptyQueueException {
        T[] aux = (T[]) new Object[maxSize + 10];
        for (int i = 0; i < maxSize; i++) {
            aux[i] = queue[i];
            dequeue();
        }
        queue = aux;
        maxSize += 10;
    }
}