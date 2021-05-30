package DataStructures.Trees.BinarySearchTrees;

import DataStructures.Trees.Common.BinaryTree;
import DataStructures.Trees.Common.ElementNotInTreeException;
import DataStructures.Trees.Common.EmptyTreeException;
import DataStructures.Trees.Common.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
    TreeNode<T> root;

    public BinarySearchTree() { root = null; }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public T getRoot() {
        return root.value;
    }

    @Override
    public BinaryTree<T> getLeft(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.left;
        return t;
    }
    @Override
    public BinaryTree<T> getRight(){ // Exceptions should be added in case there is no left or right child?
            BinarySearchTree<T> t = new BinarySearchTree<T>();
            t.root = root.right;
            return t;

    }

    public T getMax() throws EmptyTreeException {
        return getMax(root).value;
    }
    private TreeNode<T> getMax(TreeNode<T> t) throws EmptyTreeException {
        if (!isEmpty()) {
            if (t.right == null)
                return t;
            else
                return getMax(t.right);
        }
        else {throw new EmptyTreeException("There are no elements in the tree, no max value could be found");}
    }
    public T getMin() throws EmptyTreeException {
        return getMin(root).value;
    }

    private TreeNode<T> getMin(TreeNode<T> t) throws EmptyTreeException {
        if (!isEmpty()) {
            if (t.left == null)
                return t;
            else
                return getMin(t.left);
        } else {
            throw new EmptyTreeException("There are no elements in the tree, no min value could be found");
        }
    }

    public void insert(Comparable <T> x){
        root = insert(root, x);
    }

    public void delete(Comparable <T> x) throws EmptyTreeException { root = delete(root, x);}

    public boolean exists(Comparable<T> x){
        return exists(root, x);
    }

    private TreeNode<T> insert (TreeNode <T> t, Comparable <T> x) { //Can we have repeated values??

        if (t == null){
            t = new TreeNode<>();
            t.value = (T) x;

        }
        else if (x.compareTo(t.value) < 0)
            t.left = insert(t.left, x);
        else
            t.right = insert(t.right, x);
        return t;
    }

    public T search(Comparable<T> x) throws ElementNotInTreeException {
        return search(root,x).value;
    }

    public int k = 0;
    private TreeNode<T> search(TreeNode<T> t, Comparable<T> x) throws ElementNotInTreeException {
        if (!isEmpty()) {
            if (x.compareTo(t.value) == 0 && exists(x))
                return t;
            else if (x.compareTo(t.value) < 0 && exists(x)) {
                k++;
                return search(t.left, x);
            }
            else if (x.compareTo(t.value) > 0 && exists(x)) {
                k++;
                return search(t.right, x);
            }
        }
        throw new ElementNotInTreeException("The element is not in the tree");
    }

    private boolean exists(TreeNode<T> t, Comparable<T> x) {

        if (t == null)
            return false;
        if (x.compareTo(t.value) == 0)
            return true;
        else if (x.compareTo( t.value)< 0)
            return exists(t.left, x);
        else
            return exists(t.right, x);
    }


    private TreeNode<T> delete(TreeNode<T> t, Comparable<T> x) throws EmptyTreeException {
        if (!isEmpty()) {
            if (x.compareTo(t.value) < 0)
                t.left = delete(t.left, x);
            else if (x.compareTo(t.value) > 0)
                t.right = delete(t.right, x);
            else if (t.left != null && t.right != null) {
                t.value = getMin(t.right).value;
                t.right = deleteMin(t.right);
            } else if (t.left != null)
                t = t.left;
            else
                t = t.right;
            return t;
        }
        else{ throw new EmptyTreeException("The tree is empty, add elements before deleting"); }
    }

    private TreeNode<T> deleteMin(TreeNode<T> t) throws EmptyTreeException {
        if (!isEmpty()) {
            if (t.left != null)
                t.left = deleteMin(t.left);
            else
                t = t.right;
            return t;
        }
        else {throw new EmptyTreeException("The tree is empty, add elements before deleting");}
    }

    public int height(BinaryTree<T> aTree) {
        if (aTree.isEmpty()) {
            return -1;
        }
        int heightL = height(aTree.getLeft());
        int heightR = height(aTree.getRight());
        return 1 + Math.max(heightL, heightR);
    }
}

