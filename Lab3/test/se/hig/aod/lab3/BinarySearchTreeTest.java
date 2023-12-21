package se.hig.aod.lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Test class for a {@link BinarySearchTree} with Integers
 *
 * @author Selma Abbassi
 */
class BinarySearchTreeTest {

        BinarySearchTree<Integer> searchTree;
        private final int[] testData = {2, 4, 3, 5, 1};

        @BeforeEach
        void setUp() {
                searchTree = new BinarySearchTree<>();
        }

        /**
         * Test method for {@link BinarySearchTree#size()} should be 0 when empty
         */
        @Test
        void testSizeOnEmptyTree() {
                int size = searchTree.size();
                assertEquals(0, size);
        }

        /**
         * Test method for {@link BinarySearchTree#size()} should be 5 with initialized testData
         */
        @Test
        void testSizeOnInitializedTree() {
                initializeSearchTree();
                int size = searchTree.size();
                assertEquals(5, size);
        }

        /**
         * Test method for {@link BinarySearchTree#addElement(Comparable)} should add new element to empty tree and increase size
         */
        @Test
        void testAddElementToEmptyTree() {
                searchTree.addElement(6);
                int size = searchTree.size();
                assertEquals(1, size);
        }

        /**
         * Test method for {@link BinarySearchTree#addElement(Comparable)} should add new element to initialized tree and increase size
         */
        @Test
        void testAddElementToInitializedTree() {
                initializeSearchTree();
                searchTree.addElement(6);
                int size = searchTree.size();
                assertEquals(6, size);
        }

        /**
         * Test method for {@link BinarySearchTree#addElement(Comparable)} should be able to add duplicates to initialized tree and increase size
         */
        @Test
        void testAddElementDuplicateToInitializedTree() {
                initializeSearchTree();
                searchTree.addElement(1);
                int size = searchTree.size();
                assertEquals(6, size);
        }

        /**
         * Test method for {@link BinarySearchTree#searchElement(Comparable)} should return null when tree is empty
         */
        @Test
        void testSearchElementInEmptyTree() {
                Integer searchElement = 3;
                Integer foundElement = searchTree.searchElement(searchElement);

                assertNull(foundElement);
        }

        /**
         * Test method for {@link BinarySearchTree#searchElement(Comparable)} should find element to the left of root in initialized tree
         */
        @Test
        void testSearchElementFoundToLeftInInitializedTree() {
                initializeSearchTree();
                int searchElement = 1;
                Integer foundElement = searchTree.searchElement(searchElement);

                assertEquals(searchElement, foundElement);
        }

        /**
         * Test method for {@link BinarySearchTree#searchElement(Comparable)} should find element to the right of root in initialized tree
         */
        @Test
        void testSearchElementFoundToRightInInitializedTree() {
                initializeSearchTree();
                Integer searchElement = 3;
                Integer foundElement = searchTree.searchElement(searchElement);

                assertEquals(searchElement, foundElement);
        }

        /**
         * Test method for {@link BinarySearchTree#searchElement(Comparable)} should find duplicate element
         */
        @Test
        void testSearchElementDuplicateInInitializedTree() {
                initializeSearchTree();
                int searchElement = 1;

                searchTree.addElement(searchElement);
                Integer foundElement = searchTree.searchElement(searchElement);

                assertEquals(searchElement, foundElement);
        }

        /**
         * Test method for {@link BinarySearchTree#searchElement(Comparable)} should return null when element not found in initialized tree
         */
        @Test
        void testSearchElementNotFoundInInitializedTree() {
                initializeSearchTree();
                int searchElement = 7;
                Integer foundElement = searchTree.searchElement(searchElement);

                assertNull(foundElement);
        }

        /**
         * Test method for {@link BinarySearchTree#toString()} should return empty string when tree is empty
         */
        @Test
        void testToStringInOrderOnEmptyTree() {
                String searchTreeString = searchTree.toString();
                assertEquals("", searchTreeString);
        }

        /**
         * Test method for {@link BinarySearchTree#toString()} should return inOrder string representation when tree is initialized
         */
        @Test
        void testToStringInOrderOnInitializedTree() {
                initializeSearchTree();
                String searchTreeString = searchTree.toString();
                assertEquals("12345", searchTreeString);
        }

        private void initializeSearchTree() {
                for (int i : testData) {
                        searchTree.addElement(i);
                }
        }
}