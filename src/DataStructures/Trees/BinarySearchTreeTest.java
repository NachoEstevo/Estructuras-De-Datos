package DataStructures.Trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void getMaxAndGetMin() throws EmptyTreeException {
        BinarySearchTree<Integer> anIntTree = new BinarySearchTree<>();
        anIntTree.insert(14);
        anIntTree.insert(12);
        anIntTree.insert(23);
        anIntTree.insert(41);
        anIntTree.insert(1);
        anIntTree.insert(5);

        assertEquals(41,anIntTree.getMax());
        assertEquals(1,anIntTree.getMin());

    }

}