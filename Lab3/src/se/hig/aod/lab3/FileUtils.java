package se.hig.aod.lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    public static List<Integer> loadListFromFile(String path, int size)
            throws FileNotFoundException, IOException {
        List<Integer> list = new ArrayList<Integer>();
        int cnt = 0;
        try (Scanner in = new Scanner(new FileReader(path))) {
            while (cnt < size && in.hasNextLine()) {
                String line = in.nextLine();
                try {
                    list.add(Integer.parseInt(line));
                    cnt++;
                } catch (NumberFormatException nfe) {
                    System.err.printf("Not an integer while reading from data file " +
                            "%s\": %s (ignoring)%n", path, nfe.getLocalizedMessage());
                }
            }
        }// här har in.close() garanterat anropats
        if (cnt != size) {
            System.err.printf("Didn't read %d integers, only %d.%n", size, cnt);
        }
        return list;
    }
}
