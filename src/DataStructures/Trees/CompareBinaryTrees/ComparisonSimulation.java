package DataStructures.Trees.CompareBinaryTrees;

import DataStructures.Trees.BinarySearchTrees.BinarySearchTree;
import DataStructures.Trees.Common.ElementNotInTreeException;

import java.util.Arrays;
import java.util.Random;

public class ComparisonSimulation {
        public static long bstFillTime = 0;
        public static long avlFillTime = 0;
        public static long rbFillTime = 0;

        public static float bstheight = 0;
        public static float avlheight = 0;
        public static float rbheight = 0;

        public static float bstSearchAttempts = 0;
        public static float avlSearchAttempts = 0;
        public static float rbSearchAttempts = 0;

        public static void main(String[] args) throws ElementNotInTreeException {
            int[] anIntArray = generateRandomArray();
            BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
            System.out.println("Time in miliseconds taken to fill a BinarySearch Tree: " +fillBinaryTree(binarySearchTree, anIntArray));

            AVLTree<Integer> avlTree = new AVLTree<>();
            System.out.println("Time in miliseconds taken to fill an AVL Tree: " +fillAVLTree(avlTree, anIntArray));

            RBTree<Integer> redBlackTree = new RBTree<>();
            System.out.println("Time in miliseconds taken to fill a Red and Black Tree: " + fillRBTree(redBlackTree, anIntArray) + "\n");

            System.out.println("Heights");
            System.out.println("------------------------------");

            System.out.println("Binary Tree height: " + binarySearchTree.height(binarySearchTree));
            System.out.println("AVL Tre height: " + avlTree.height(avlTree));
            System.out.println("Red Black Tree height: " + redBlackTree.height(redBlackTree));

            //Search elements
            //Array of numbers to search
            int[] toSearch = get10Random(anIntArray);
            float bstAttempts = 0;
            float avlAttempts = 0;
            float rbAttempts = 0;

            System.out.println("\nElements to search " + Arrays.toString(toSearch) + "\n");
            for (int i: toSearch) {
                binarySearchTree.search(i);
                System.out.println("Binary Search Tree element: " + i + " found in " + binarySearchTree.k +" attempts");
                bstAttempts += binarySearchTree.k;

                avlTree.search(i);
                System.out.println("AVL Tree element: " + i + " found in " + avlTree.k + " attempts");
                avlAttempts += avlTree.k;

                redBlackTree.searchTree(i);
                System.out.println("Red Black Tree element: " + i + " found in " + redBlackTree.k +" attempts\n");
                rbAttempts += redBlackTree.k;
            }
            System.out.println("In average, a Binary Search Tree needed " + bstAttempts/10 + " attempts to find a random element");
            System.out.println("In average, a Binary Search Tree needed " + avlAttempts/10 + " attempts to find a random element");
            System.out.println("In average, a Binary Search Tree needed " + rbAttempts/10 + " attempts to find a random element");
            System.out.println("------------\n");

            for (int i = 0; i < 10; i++) {
                int[] randArray = generateRandomArray();
                completeSimulation(randArray);
            }
            System.out.println("---------");
            System.out.println("After 10 repetitions, a Binary search tree had an average fill time of: " + bstFillTime + " miliseconds. An average height of " + bstheight/10 + " and an average of "+ bstAttempts/10 + " attempts to search for an element");
            System.out.println("After 10 repetitions, an AVL tree had an average fill time of: " + avlFillTime + " miliseconds. An average height of " + avlheight/10 + " and an average of " + avlAttempts/10 + " attempts to search for an element");
            System.out.println("After 10 repetitions, a Red and Black tree had an average fill time of: " + rbFillTime + " miliseconds. An average height of " + rbheight/10 + " and an average of " + rbAttempts/10 + " attempts to search for an element");
        }

        private static long fillBinaryTree(BinarySearchTree<Integer> aTree, int[] anIntArray) { // Retorna el tiempo que tarda en insertar todos los valores al arbol
            long start = System.currentTimeMillis();
            for (int integer : anIntArray) {
                aTree.insert(integer);
            }
            long finish = System.currentTimeMillis();

            return (finish - start);
        }
        private static long fillRBTree(RBTree<Integer> aTree, int[] anIntArray) { // Retorna el tiempo que tarda en insertar todos los valores al arbol
            long start = System.currentTimeMillis();
            for (int integer : anIntArray) {
                aTree.insert(integer);
            }
            long finish = System.currentTimeMillis();

            return (finish - start);
        }
        private static long fillAVLTree(AVLTree<Integer> aTree, int[] anIntArray) { // Retorna el tiempo que tarda en insertar todos los valores al arbol
            long start = System.currentTimeMillis();
            for (int integer : anIntArray) {
                aTree.insert(integer);
            }
            long finish = System.currentTimeMillis();
            return (finish - start);
        }


        public static int[] generateRandomArray(){//Using other methods result in way longer fill times.
            return new Random().ints(0, 100000)
                    .distinct()
                    .limit(1000).toArray();
        }

        public static int[] get10Random(int[] anArray){
            int[] newArr = new int[10];
            for (int i = 0; i < 10; i++) {
                int rnd = new Random().nextInt(anArray.length);
                newArr[i] = anArray[rnd];
            }
            return newArr;
        }

        public static void completeSimulation(int[] anIntArray) throws ElementNotInTreeException {
            BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
            bstFillTime += fillBinaryTree(binarySearchTree, anIntArray);

            AVLTree<Integer> avlTree = new AVLTree<>();
            avlFillTime += fillAVLTree(avlTree, anIntArray);

            RBTree<Integer> redBlackTree = new RBTree<>();
            rbFillTime +=  fillRBTree(redBlackTree, anIntArray);

            bstheight +=  binarySearchTree.height(binarySearchTree);
            avlheight += avlTree.height(avlTree);
            rbheight += redBlackTree.height(redBlackTree);

            int[] toSearch = get10Random(anIntArray);
            for (int i: toSearch) {
                binarySearchTree.search(i);
                bstSearchAttempts += binarySearchTree.k;

                avlTree.search(i);
                avlSearchAttempts += avlTree.k;

                redBlackTree.searchTree(i);
                rbSearchAttempts += redBlackTree.k;
            }
            bstSearchAttempts /= 10;
            avlSearchAttempts /= 10;
            rbSearchAttempts /= 10;
        }
    }

