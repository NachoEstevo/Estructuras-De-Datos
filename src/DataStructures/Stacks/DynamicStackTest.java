package DataStructures.Stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicStackTest {

    @Test
    void push_Should_Update_The_Top() throws EmptyStackException {
        DynamicStack<Integer> anIntStack = new DynamicStack();
        anIntStack.push(31);
        anIntStack.push(44);

        assertEquals(44,anIntStack.peek());

        anIntStack.pop();
        assertEquals(31,anIntStack.peek());

        anIntStack.empty();

    }
}