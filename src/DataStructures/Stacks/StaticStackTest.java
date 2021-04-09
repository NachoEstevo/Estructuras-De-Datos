package DataStructures.Stacks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StaticStackTest {

    @Test
    void push_Should_Insert_Value_And_Move_Top() throws EmptyStackException {
        StaticStack<Integer> anIntStack = new StaticStack<Integer>(); //If more than 10 elements are entered it doesn't crash
        anIntStack.push(3);
        anIntStack.push(12);
        anIntStack.push(14);
        anIntStack.push(413);
        anIntStack.push(311);
        anIntStack.push(32);
        anIntStack.push(331);
        anIntStack.push(63);
        anIntStack.push(378);
        anIntStack.push(311);
        anIntStack.push(331);
        anIntStack.push(3422);

        assertEquals(anIntStack.peek(),3422);

    }

    @Test
    void pop_Should_Move_The_Top() throws EmptyStackException {
        StaticStack<Integer> anIntStack = new StaticStack<Integer>();
        anIntStack.push(3);
        anIntStack.push(8);
        anIntStack.pop();
        assertEquals(anIntStack.peek(),3);

        anIntStack.push(14);
        assertEquals(anIntStack.peek(),14);
    }
}