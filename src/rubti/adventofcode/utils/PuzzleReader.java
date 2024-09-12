package rubti.adventofcode.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PuzzleReader {

    public PuzzleReader(String inputFile) throws FileNotFoundException {
    }

    public static ArrayList<String> getPuzzle(String inputFile) throws FileNotFoundException {
        File my_file = new File(inputFile);
        Scanner reader = new Scanner(my_file);
        var fileContent = new ArrayList<String>();
        try {
            while (reader.hasNextLine()) {
                fileContent.add(reader.nextLine());
            }

        } finally {
            reader.close();
        }
        return fileContent;
    }

}
