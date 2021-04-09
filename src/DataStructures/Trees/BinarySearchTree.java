package DataStructures.Trees;

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
    public BinaryTree<T> getRight(){
        BinarySearchTree<T> t = new BinarySearchTree<T>();
        t.root = root.right;
        return t;
    }

    public T getMax(){
        return getMax(root).value;
    }
    private TreeNode<T> getMax(TreeNode<T> t){
        if (t.right == null)
            return t;
        else
            return getMax(t.right);
    }
    public T getMin(){
        return getMin(root).value;
    }
    private TreeNode<T> getMin(TreeNode<T> t){
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }


    public void insert(Comparable <T> x){
        root = insert(root, x);
    }
    public void delete(Comparable <T> x){
        root = delete(root, x);
    }

    public boolean exists(Comparable<T> x){
        return exists(root, x);
    }


    private TreeNode<T> insert (TreeNode <T> t, Comparable <T> x) {
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

    public T search(Comparable<T> x){
        return search(root,x).value;
    }
    private TreeNode<T> search(TreeNode<T> t, Comparable<T> x){
        if (x.compareTo(t.value)== 0)
            return t;
        else if (x.compareTo( t.value)< 0)
            return search(t.left, x);
        else
            return search(t.right, x);
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


    private TreeNode<T> delete(TreeNode<T> t, Comparable<T> x) {
        if (x.compareTo(t.value) < 0)
            t.left = delete(t.left, x);
        else if (x.compareTo(t.value) > 0)
            t.right = delete(t.right, x);
        else
        if (t.left != null && t.right != null ) {
            t.value = getMin(t.right).value;
            t.right = deleteMin(t.right);
        }
        else if (t.left != null)
            t = t.left;
        else
            t =t.right;
        return t;
    }

    private TreeNode<T> deleteMin(TreeNode<T> t){
        if (t.left != null)
            t.left = deleteMin(t.left);
        else
            t = t.right;
        return t;
    }
}

