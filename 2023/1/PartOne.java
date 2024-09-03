import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PartOne {
    public static void main(String args[]) throws FileNotFoundException {
        File my_file = new File("puzzle.txt");
        Scanner reader = new Scanner(my_file);
        try {
            int sum = 0;
            while (reader.hasNextLine()) {
                var input = reader.nextLine();
                // Regex pattern to find the first number
                Pattern firstPattern = Pattern.compile("\\d");
                Matcher firstMatcher = firstPattern.matcher(input);
                String firstNumber = null;
                if (firstMatcher.find()) {
                    firstNumber = firstMatcher.group();
                }

                // Regex pattern to find the last number
                Pattern lastPattern = Pattern.compile("\\d(?!.*\\d)");
                Matcher lastMatcher = lastPattern.matcher(input);
                String lastNumber = null;
                if (lastMatcher.find()) {
                    lastNumber = lastMatcher.group();
                }
                sum += Integer.parseInt(firstNumber + lastNumber);
            }
            System.out.println("The result of the 1/1 Advent of Code Puzzle is: " + sum);
        } finally {
            reader.close();
        }
    }
}