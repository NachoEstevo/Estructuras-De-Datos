package DataStructures.Trees.BinaryTrees;

import DataStructures.Queues.EmptyQueueException;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void treeTest() throws EmptyQueueException {

        Tree<Integer> leftChild = new Tree<Integer>(10,new Tree<>(8),new Tree<>(18));
        Tree<Integer> rightChild = new Tree<Integer>(20, new Tree<>(18), new Tree<>(36));

        Tree<Integer> tree = new Tree<Integer>(40, leftChild, rightChild);
        Tree<Integer> treeB = new Tree<Integer>(40, leftChild, rightChild);


        System.out.print("Inorder tree: ");
        tree.inOrden(tree);

        System.out.print("\n" + "\n" + "porNiveles tree: ");
        tree.porNiveles(tree);

        System.out.print("\n" +  "\n" +"PostOrder tree: ");
        tree.postOrden(tree);

        System.out.println("\n" + "\n" + "Elements in level 1: " + tree.elementsInGivenLevel(tree,1) + "\n");
        assertEquals(tree.elementsInGivenLevel(tree,1),2);

        System.out.println("Root: " + tree.getRoot());
        assertEquals(tree.getRoot(),(Integer)40);

        System.out.println("\n" + "Leaves in tree: " + tree.getNumberOfLeaves(tree));
        assertEquals(tree.getNumberOfLeaves(tree),4);

        System.out.println("\n" + "Repeated Values: " + tree.repeatedValues(tree,18));
        assertEquals(tree.repeatedValues(tree,18),2);

        System.out.println("\n" +"Is the tree complete? "+ tree.isComplete(tree));
        assertTrue(tree.isComplete(tree));

        System.out.println("\n" +"The sum of its elements is: "+ tree.sumOfElements(tree));
        assertEquals(tree.sumOfElements(tree), 150);

        System.out.println("\n" + "Frontier: " + tree.frontierList(tree).toString());

        System.out.println("\n" + "Weight:" + tree.getWeight(tree));
        System.out.println("\n" + "Height:" + tree.height(tree));
        System.out.println("\n" + "Sum of the multiples of 3:" + tree.sumOfMultiplesOf3(tree));

        System.out.println("\n" + "Is the tree full? " +tree.isFull(tree));
        System.out.println("\n" + "Are tree and treeB similar? " +tree.areSimilar(tree,treeB));
        assertTrue(tree.areSimilar(tree, treeB)); //This should return true as they are the same tree
    }

}