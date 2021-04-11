package DataStructures.Trees;

import java.util.ArrayList;

public class Tree<T extends Comparable<T>> implements BinaryTree<T> {
    TreeNode<T> root;

    public Tree(){ root = null;}

    public Tree(T root){
        this.root = new TreeNode<T>(root);
    }

    public Tree(T root, Tree<T> tleft, Tree<T> tright){ this.root = new TreeNode<T>(root,tleft.root,tright.root);}

    @Override
    public T getRoot() {
        return root.value;
    }

    @Override
    public BinaryTree<T> getLeft(){
        BinarySearchTree<T> t = new BinarySearchTree<>();
        t.root = root.left;
        return t;
    }
    @Override
    public BinaryTree<T> getRight(){
        BinarySearchTree<T> t = new BinarySearchTree<>();
        t.root = root.right;
        return t;
    }
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    //Exercises
    public int getWeight(BinaryTree<T> aTree) {

        if (!aTree.isEmpty()) {
            return  getWeight(aTree.getLeft()) + getWeight(aTree.getRight()) + 1;
        } else {
            return 0;
        }
    }
    public int height(BinaryTree<T> aTree) {
        if (aTree.isEmpty()) {
            return -1;
        }
        int heightL = height(aTree.getLeft());
        int heightR = height(aTree.getRight());
        return 1 + Math.max(heightL, heightR);
    }

    public int getNumberOfLeaves(BinaryTree<T> aTree) {
        if(aTree.isEmpty()){
            return 0;
        }
        if(aTree.getLeft().isEmpty() && aTree.getRight().isEmpty()){
            return 1;
        }
        return getNumberOfLeaves(aTree.getLeft()) + getNumberOfLeaves(aTree.getRight());
    }

    public int repeatedValues(BinaryTree<T> tree, T value){
        if(tree.isEmpty())
            return 0;
        if(tree.getRoot().equals(value))
            return 1 + repeatedValues(tree.getLeft(),value)+repeatedValues(tree.getRight(),value);
        else
            return repeatedValues(tree.getLeft(),value)+repeatedValues(tree.getRight(),value);
    }

    public int elementsInGivenLevel(BinaryTree<T> aTree, int level){
        if (aTree.isEmpty()){
            return 0;
        }
        if (level == 0){
            return 1;
        }
        return elementsInGivenLevel(aTree.getLeft(), level -1) + elementsInGivenLevel(aTree.getRight(),level-1);
    }


    private  boolean isLeaf(BinaryTree<T> aTree) {
        return aTree.getRight().isEmpty() && aTree.getLeft().isEmpty();
    }


    //Ejercicio 14

    public int sumOfElements(BinaryTree<T> aTree) {
        if(aTree.isEmpty()) {
            return 0;
        }
        return  sumOfElements(aTree.getLeft()) + sumOfElements(aTree.getRight()) + (Integer) aTree.getRoot();
    }

    public int sumOfMultiplesOf3(BinaryTree<T> aTree) {
        if (aTree.isEmpty()) {
            return 0;
        }
        if ((Integer) aTree.getRoot() % 3 == 0) {
            return sumOfMultiplesOf3(aTree.getLeft()) + (Integer) aTree.getRoot() + sumOfMultiplesOf3(aTree.getRight());
        }
        return -1;
    }

    public boolean isComplete(BinaryTree<T> aTree){
        if(aTree.isEmpty()){
            return false;
        }
        if((aTree.getLeft().isEmpty()) && (aTree.getRight().isEmpty())){
            return true;
        }
        if((aTree.getLeft().isEmpty()) || (aTree.getRight().isEmpty())){
            return false;
        }
        return isComplete(aTree.getLeft()) && isComplete(aTree.getRight());
    }



    public boolean isFull(BinaryTree<T> aTree){ //IsComplete y todas las hojas estan en el mismo nivel
        if (!aTree.isEmpty()) {
            if(aTree.getRight().isEmpty() && aTree.getLeft().isEmpty())
            {
                return true;
            }
            if ((!aTree.getRight().isEmpty() && !aTree.getLeft().isEmpty()))
            {
                return isFull(aTree.getLeft())&&isFull(aTree.getLeft());
            }
        }
        return false;
    }

    private int completeNodes(BinaryTree<T> a){
        if(a.isEmpty())
            return 0;
        if (a.getLeft().isEmpty())
            return completeNodes(a.getRight());
        if (a.getRight().isEmpty())
            return completeNodes(a.getLeft());
        return
                1+completeNodes(a.getRight())+completeNodes(a.getLeft());
    }
    private int numberOfNodes(BinaryTree<T> aTree){
        return numberOfNodes((Tree<T>) aTree.getLeft())+numberOfNodes((Tree<T>) aTree.getRight()) + 1;
    }
    public boolean areEqual(BinaryTree<T> treeA, BinaryTree<T> treeB){
        if (treeA == null && treeB == null) {
            return true;
        }
        if (treeA == null || treeB == null) {
            return false;
        }
        if (treeA.getRoot() != treeB.getRoot())
            return false;

        if (!areEqual(treeA.getRight(), treeB.getLeft()))
            return false;

        return areEqual(treeA.getRight(), treeB.getRight());
    }
    private boolean treeCompare(BinaryTree<T> aTree, BinaryTree<T> bTree) { //Another Solution for areEqual
        if (aTree == bTree) {
            return true;
        }

        if (aTree == null || !aTree.equals(bTree)) {
            return false;
        }

        return treeCompare(aTree.getLeft(), bTree.getLeft()) && treeCompare(aTree.getRight(), bTree.getRight());
    }
    public boolean areIsomorfal(BinaryTree<T> treeA, BinaryTree<T> treeB){

        if (treeA.isEmpty() && treeB.isEmpty()) {
            return true;
        }
        if (treeA.isEmpty() && !treeB.isEmpty() || !treeA.isEmpty() && treeB.isEmpty()){
            return false;
        }
        else{
            return (areIsomorfal(treeA.getLeft(), treeB.getLeft()) && areIsomorfal(treeA.getRight(), treeB.getRight()));
        }
    }
    public boolean areSimilar(BinaryTree<T> treeA, BinaryTree<T> treeB){ //Semejantes

        if(!treeA.getRoot().equals(treeB.getRoot())){
            return false;
        }
        if(treeA.getRoot().equals(treeB.getRoot())){
            return true;
        }
        return areSimilar(treeA.getLeft(), treeB.getLeft()) && areSimilar(treeA.getRight(), treeB.getRight());
    }

    public boolean isStable(BinaryTree<Integer> aTree){
        if(aTree.isEmpty()){
            return true;
        }
        if(aTree.getLeft().isEmpty() && aTree.getRight().isEmpty()){
            return true;
        }
        if(aTree.getRoot() < aTree.getRight().getRoot() || aTree.getRoot() < aTree.getLeft().getRoot()){
            return false;
        }
        isStable(aTree.getLeft());
        isStable(aTree.getRight());
        return true;
    }

    public boolean occursInTree(BinaryTree<T> treeA, BinaryTree<T> treeB){
        if (treeA.isEmpty()){
            return false;
        }
        if (treeB.isEmpty()){
            return true;
        }
        if(areEqual(treeA,treeB)) {
            return true;
        }
        return occursInTree(treeA.getLeft(),treeB) || occursInTree(treeA.getRight(),treeB);
    }

    public void inorden(BinaryTree<T> a){
        if(!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println(a.getRoot());
            inorden(a.getRight());
        }
    }



    public ArrayList<T> frontierList(BinaryTree<T> aTree) {
        ArrayList<T> frontier = new ArrayList<>();
        if (aTree.isEmpty()) {
            return frontier;
        }
        if ((!aTree.getLeft().isEmpty() || (!aTree.getRight().isEmpty()))) {
            ArrayList<T> frontier1 = new ArrayList<>();
            frontier1.addAll(frontierList(aTree.getRight()));
            frontier1.addAll(frontierList(aTree.getLeft()));
            return frontier1;
        }
        if((aTree.getLeft().isEmpty()) && (aTree.getRight().isEmpty())){
            frontier.add(aTree.getRoot());

        }return frontier;

    }

}



