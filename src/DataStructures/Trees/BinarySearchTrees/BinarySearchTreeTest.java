package DataStructures.Trees.BinarySearchTrees;

import DataStructures.Trees.Common.ElementNotInTreeException;
import DataStructures.Trees.Common.EmptyTreeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinarySearchTreeTest {
    //Genome Simulation contains the use of a Genome Binary Tree

    @Test
    void getMaxAndGetMin() throws EmptyTreeException, ElementNotInTreeException { //Basic SimulacionArchivos for an integer tree. Genome Simulation contains the use of a Genome Binary Tree
        BinarySearchTree<Integer> anIntTree = new BinarySearchTree<>();
        anIntTree.insert(14);
        anIntTree.insert(12);
        anIntTree.insert(23);
        anIntTree.insert(41);
        anIntTree.insert(1);
        anIntTree.insert(5);

        assertEquals(41,anIntTree.getMax());
        assertEquals(1,anIntTree.getMin());

        assertTrue(anIntTree.exists(14));
        System.out.println("Existe el elemento 14? " + anIntTree.exists(14));

        assertEquals(anIntTree.search(5), 5);
        System.out.println("Existe el 5? Si existe retornarlo: " + anIntTree.search(5));

    }

}