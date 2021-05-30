package DataStructures.Trees.CompareBinaryTrees;

import DataStructures.Trees.Common.BinaryTree;

public class AVLTree<T extends Comparable<T>> implements BinaryTree<Integer> {
    private AVLNode root = null;

    public void insert(int data) {
        insert(root, data);
    }

    private int height(AVLNode AVLNode) {
        return AVLNode == null ? -1 : AVLNode.height;
    }

    private void insert(AVLNode AVLNode, int value) {
        if (root == null) {
            root = new AVLNode(value, null);
            return;
        }

        if (value < AVLNode.value) {
            if (AVLNode.left != null) {
                insert(AVLNode.left, value);
            } else {
                AVLNode.left = new AVLNode(value, AVLNode);
            }

            if (height(AVLNode.left) - height(AVLNode.right) == 2) { //left heavier
                if (value < AVLNode.left.value) {
                    rotateRight(AVLNode);
                } else {
                    rotateLeftThenRight(AVLNode);
                }
            }
        } else if (value > AVLNode.value) {
            if (AVLNode.right != null) {
                insert(AVLNode.right, value);
            } else {
                AVLNode.right = new AVLNode(value, AVLNode);
            }

            if (height(AVLNode.right) - height(AVLNode.left) == 2) { //right heavier
                if (value > AVLNode.right.value)
                    rotateLeft(AVLNode);
                else {
                    rotateRightThenLeft(AVLNode);
                }
            }
        }

        reHeight(AVLNode);
    }

    private void rotateRight(AVLNode pivot) {
        AVLNode parent = pivot.parent;
        AVLNode leftChild = pivot.left;
        AVLNode rightChildOfLeftChild = leftChild.right;
        pivot.setLeftChild(rightChildOfLeftChild);
        leftChild.setRightChild(pivot);
        if (parent == null) {
            this.root = leftChild;
            leftChild.parent = null;
            return;
        }

        if (parent.left == pivot) {
            parent.setLeftChild(leftChild);
        } else {
            parent.setRightChild(leftChild);
        }

        reHeight(pivot);
        reHeight(leftChild);
    }

    private void rotateLeft(AVLNode pivot) {
        AVLNode parent = pivot.parent;
        AVLNode rightChild = pivot.right;
        AVLNode leftChildOfRightChild = rightChild.left;
        pivot.setRightChild(leftChildOfRightChild);
        rightChild.setLeftChild(pivot);
        if (parent == null) {
            this.root = rightChild;
            rightChild.parent = null;
            return;
        }

        if (parent.left == pivot) {
            parent.setLeftChild(rightChild);
        } else {
            parent.setRightChild(rightChild);
        }

        reHeight(pivot);
        reHeight(rightChild);
    }

    private void reHeight(AVLNode AVLNode) {
        AVLNode.height = Math.max(height(AVLNode.left), height(AVLNode.right)) + 1;
    }

    private void rotateLeftThenRight(AVLNode AVLNode) {
        rotateLeft(AVLNode.left);
        rotateRight(AVLNode);
    }

    private void rotateRightThenLeft(AVLNode AVLNode) {
        rotateRight(AVLNode.right);
        rotateLeft(AVLNode);
    }

    public boolean delete(int key) {
        AVLNode target = search(key);
        if (target == null) return false;
        target = deleteAVLNode(target);
        balanceTree(target.parent);
        return true;
    }

    private AVLNode deleteAVLNode(AVLNode target) {
        if (isLeaf(target)) { //leaf
            if (isLeftChild(target)) {
                target.parent.left = null;
            } else {
                target.parent.right = null;
            }
        } else if (target.left == null ^ target.right == null) { //exact 1 child
            AVLNode nonNullChild = target.left == null ? target.right : target.left;
            if (isLeftChild(target)) {
                target.parent.setLeftChild(nonNullChild);
            } else {
                target.parent.setRightChild(nonNullChild);
            }
        } else {//2 children
            AVLNode immediatePredInOrder = immediatePredInOrder(target);
            target.value = immediatePredInOrder.value;
            target = deleteAVLNode(immediatePredInOrder);
        }

        reHeight(target.parent);
        return target;
    }

    private AVLNode immediatePredInOrder(AVLNode AVLNode) {
        AVLNode current = AVLNode.left;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    private boolean isLeftChild(AVLNode child) {
        return (child.parent.left == child);
    }

    private boolean isLeaf(AVLNode AVLNode) {
        return AVLNode.left == null && AVLNode.right == null;
    }

    private int calDifference(AVLNode AVLNode) {
        int rightHeight = height(AVLNode.right);
        int leftHeight = height(AVLNode.left);
        return rightHeight - leftHeight;
    }

    private void balanceTree(AVLNode AVLNode) {
        int difference = calDifference(AVLNode);
        AVLNode parent = AVLNode.parent;
        if (difference == -2) {
            if (height(AVLNode.left.left) >= height(AVLNode.left.right)) {
                rotateRight(AVLNode);
            } else {
                rotateLeftThenRight(AVLNode);
            }
        } else if (difference == 2) {
            if (height(AVLNode.right.right) >= height(AVLNode.right.left)) {
                rotateLeft(AVLNode);
            } else {
                rotateRightThenLeft(AVLNode);
            }
        }

        if (parent != null) {
            balanceTree(parent);
        }

        reHeight(AVLNode);
    }

    public AVLNode<T> search(int key) { return binarySearch(root, key);}

    int k = 0;
    private AVLNode<T> binarySearch(AVLNode<T> AVLNode, int key) {
        if (AVLNode == null) return null;

        if (key == AVLNode.value) {
            return AVLNode;
        }

        if (key < AVLNode.value && AVLNode.left != null) {
            k++;
            return binarySearch(AVLNode.left, key);
        }

        if (key > AVLNode.value && AVLNode.right != null) {
            k++;
            return binarySearch(AVLNode.right, key);
        }

        return null;
    }

    public void traverseInOrder() {
        System.out.println("ROOT " + root.toString());
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode<T> AVLNode) {
        if (AVLNode != null) {
            inorder(AVLNode.left);
            System.out.print(AVLNode.toString());
            inorder(AVLNode.right);
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Integer getRoot() {
        return root.value;
    }

    @Override
    public BinaryTree<Integer> getLeft() {
        AVLTree<Integer> t = new AVLTree<>();
        t.root = root.left;
        return t;
    }

    @Override
    public BinaryTree<Integer> getRight() {
        AVLTree<Integer> t = new AVLTree<>();
        t.root = root.right;
        return t;
    }

    public int height(BinaryTree<T> aTree) {
        if (aTree.isEmpty()) {
            return -1;
        }
        int heightL = height(aTree.getRight());
        int heightR = height(aTree.getRight());
        return 1 + Math.max(heightL, heightR);
    }
}

