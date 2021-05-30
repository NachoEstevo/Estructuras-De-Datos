package DataStructures.Trees.CompareBinaryTrees;

public class AVLNode<T> {
    AVLNode left, right;
    AVLNode parent;
    int value ;
    int height = 0;

    public AVLNode(int data, AVLNode parent) {
        this.value = data;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return value + " height " + height + " parent " + (parent == null ?
                "NULL" : parent.value) + " | ";
    }

    void setLeftChild(AVLNode child) {
        if (child != null) {
            child.parent = this;
        }

        this.left = child;
    }

    void setRightChild(AVLNode child) {
        if (child != null) {
            child.parent = this;
        }

        this.right = child;
    }
}

