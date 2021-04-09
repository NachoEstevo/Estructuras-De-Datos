package DataStructures.Queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicQueueTest {

    @Test
    void enqueue_And_Dequeue_Should_Pop_The_First_Entered_Value() throws EmptyQueueException {
        DynamicQueue<Integer> anIntQueue = new DynamicQueue<>();
        anIntQueue.enqueue(10);
        anIntQueue.enqueue(31);
        anIntQueue.enqueue(111);
        anIntQueue.enqueue(411);

        anIntQueue.getFront();
        //In a queue the first value entered is the front
        assertEquals(10,anIntQueue.getFront().getData());

        anIntQueue.dequeue();
        assertEquals(31,anIntQueue.getFront().getData());
        anIntQueue.dequeue();
        assertEquals(111,anIntQueue.getFront().getData());
        anIntQueue.dequeue();
        anIntQueue.dequeue();
        System.out.println(anIntQueue.getFront());
        //anIntQueue.dequeue(); This throws the emptyQueue exception

    }

}