import java.io.FileNotFoundException;

import rubti.adventofcode.*;
import rubti.adventofcode.utils.PuzzleReader;

public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        String PUZZLE_DIR = "puzzles/";
        new Day1(PuzzleReader.getPuzzle(PUZZLE_DIR + "day1.txt")).solve();
        new Day2(PuzzleReader.getPuzzle(PUZZLE_DIR + "day2.txt")).solve();
    }
}
