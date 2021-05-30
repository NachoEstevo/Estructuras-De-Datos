package DataStructures.Trees.CompareBinaryTrees;

public class RBNode<T> {
    int data; // holds the key
    RBNode<T> parent;
    RBNode<T> left, right;
    int color; // 1 . Red, 0 . Black
}