package se.hig.aod.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinarySearchTreeTest {

    BinarySearchTree<Integer> searchTree;
    private final int[] testData = {2, 4, 3, 5, 1};

    @BeforeEach
    void setUp() {
        searchTree = new BinarySearchTree<>();
    }

    @Test
    void testSizeOnEmptyTree() {
        int size = searchTree.size();
        assertEquals(0, size);
    }

    @Test
    void testSizeOnInitializedTree() {
        initializeSearchTree();
        int size = searchTree.size();
        assertEquals(5, size);
    }

    @Test
    void testAddElementToEmptyTree() {
        searchTree.addElement(6);
        int size = searchTree.size();
        assertEquals(1, size);
    }

    @Test
    void testAddElementToInitializedTree() {
        initializeSearchTree();
        searchTree.addElement(6);
        int size = searchTree.size();
        assertEquals(6, size);
    }

    @Test
    void testSearchElementInEmptyTree() {
        Integer searchElement = 3;

        assertThrows(BinarySearchTreeEmptyException.class,
                () -> searchTree.searchElement(searchElement), "SearchElement() should throw BinarySearchTreeEmptyException when empty");
    }

    @Test
    void testSearchElementInInitializedTree() {
        Integer searchElement = 3;
        Integer foundElement = searchTree.searchElement(searchElement);

        assertEquals(searchElement, foundElement);
    }

    private void initializeSearchTree() {
        for (int i : testData) {
            searchTree.addElement(i);
        }
    }
}