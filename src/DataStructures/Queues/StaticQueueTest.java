package DataStructures.Queues;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StaticQueueTest {

    @Test
    void enqueue_And_Dequeue_Should_Remove_The_Front() throws EmptyQueueException {
        StaticQueue<Integer> anIntQueue = new StaticQueue<>();
        //System.out.println(anIntQueue.isEmpty());

        anIntQueue.enqueue(10);
        anIntQueue.enqueue(31);
        anIntQueue.enqueue(90);

        Integer dequeued = anIntQueue.dequeue();
        assertEquals(dequeued,10);

        Integer secondDequeue = anIntQueue.dequeue();
        assertEquals(secondDequeue,31);


        //After 2 elements are removed size should be 1
        assertEquals(anIntQueue.size(),1);
    }
}