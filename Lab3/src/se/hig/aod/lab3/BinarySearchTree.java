package se.hig.aod.lab3;

public class BinarySearchTree<T extends Comparable<T>> implements SearchableDataStructure<T> {

    private TreeNode root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addElement(T newElement) {

        size++;
    }

    @Override
    public T searchElement(T elementToFind) {
        return null;
    }

    private void addElementRecursive(TreeNode current, T newElement) {
        if (newElement.compareTo(current.element) < 0) {

        }
    }

    public class TreeNode {
        T element;
        TreeNode left;
        TreeNode right;
    }
}
