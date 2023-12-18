package se.hig.aod.lab3;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static se.hig.aod.lab3.FileUtils.loadListFromFile;

public class TimeComplexityUnsorted {

        public static void main(String[] args) throws IOException {
                BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();

                int size = 2560000;
                List<Integer> dataList = loadListFromFile("src/se/hig/aod/lab3/data/data.txt", size);
                List<Integer> elementsToSearchFor = loadListFromFile("src/se/hig/aod/lab3/data/data.txt", 2500000);

                Collections.shuffle(dataList);
                dataList.forEach(searchTree::addElement);

                long t1 = System.currentTimeMillis();
                elementsToSearchFor.forEach(searchTree::searchElement);
                long exeTime = System.currentTimeMillis() - t1;
                System.out.println("Execution time searching in " + size + " (N): " + exeTime + " (ms)");
        }
}
