package DataStructures.Trees.Common;

public interface BinaryTree<T extends Comparable<T>> {

	public boolean isEmpty();
	public T getRoot();
	public BinaryTree<T> getLeft();
	public BinaryTree<T> getRight();
}