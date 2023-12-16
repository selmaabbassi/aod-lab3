package se.hig.aod.lab3;

/**
 * A Binary search tree class that stores elements in a binary tree
 * Elements in the tree are searchable
 * Uses Generic type T that should extend {@link Comparable}
 *
 * @param <T> Generic type that extends {@link Comparable}
 * @author Selma Abbassi
 */
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
        if (size == 0) {
            this.root = new TreeNode(newElement, null, null);
        } else {
            this.root.addElementRecursive(newElement);
        }
        size++;
    }

    @Override
    public T searchElement(T elementToFind) {
        if (size == 0) {
            return null;
        } else {
            return this.root.searchElementRecursive(elementToFind);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        } else {
            return this.root.toStringRecursive("");
        }
    }

    /**
     * Inner class TreeNode that represents a node in the {@link BinarySearchTree}
     * Stores the node's element of generic type T, and it's left and right child nodes
     */
    public class TreeNode {
        T element;
        TreeNode left;
        TreeNode right;

        public TreeNode(T element, TreeNode left, TreeNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        private void addElementRecursive(T newElement) {
            if (newElement.compareTo(this.element) < 0) { //add element to left
                if (this.left == null) { //left subtree empty
                    this.left = new TreeNode(newElement, null, null);
                } else { //keep going left
                    this.left.addElementRecursive(newElement);
                }
            } else {
                if (this.right == null) { //add element to right
                    this.right = new TreeNode(newElement, null, null);
                } else {
                    this.right.addElementRecursive(newElement); //keep going right
                }
            }
        }

        private T searchElementRecursive(T elementToFind) {
            if (this.element == elementToFind) {
                return this.element;
            } else {
                if (elementToFind.compareTo(this.element) < 0) { //search element to left
                    if (this.left == null) { //left subtree empty
                        return null; //element cannot be found
                    } else {
                        return this.left.searchElementRecursive(elementToFind); //keep searching left
                    }
                } else {
                    if (this.right == null) { //right subtree empty
                        return null; //element cannot be found
                    } else {
                        return this.right.searchElementRecursive(elementToFind); //keep searching right
                    }
                }
            }
        }

        private String toStringRecursive(String result) {
            if (this.left != null) {
                result = this.left.toStringRecursive(result);
            }

            result += this.element;

            if (this.right != null) {
                result = this.right.toStringRecursive(result);
            }

            return result;
        }
    }
}
