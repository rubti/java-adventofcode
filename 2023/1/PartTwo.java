import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.HashMap;

public class PartTwo {
    private static final HashMap<String, String> numbers = new HashMap<>();
    static {
        numbers.put("1", "1");
        numbers.put("2", "2");
        numbers.put("3", "3");
        numbers.put("4", "4");
        numbers.put("5", "5");
        numbers.put("6", "6");
        numbers.put("7", "7");
        numbers.put("8", "8");
        numbers.put("9", "9");
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");
    }

    public static void main(String args[]) throws FileNotFoundException {
        File my_file = new File("puzzle.txt");
        Scanner reader = new Scanner(my_file);
        try {
            int sum = 0;
            String digitRegex = "(one|two|three|four|five|six|seven|eight|nine|\\d)";
            while (reader.hasNextLine()) {
                var input = reader.nextLine();
                // Regex pattern to find the first number
                Pattern firstPattern = Pattern.compile(digitRegex);
                Matcher firstMatcher = firstPattern.matcher(input);
                String firstNumber = null;
                if (firstMatcher.find()) {
                    firstNumber = numbers.get(firstMatcher.group());
                }

                // Regex pattern to find the last number
                String lastRegex = "(?:one|two|three|four|five|six|seven|eight|nine|\\d)(?!.*(one|two|three|four|five|six|seven|eight|nine|\\d))";
                Pattern lastPattern = Pattern.compile(lastRegex);
                Matcher lastMatcher = lastPattern.matcher(input);
                String lastNumber = null;
                if (lastMatcher.find()) {
                    if (lastMatcher.group(1) != null) {
                        lastNumber = numbers.get(lastMatcher.group(1));
                    } else {
                        lastNumber = numbers.get(lastMatcher.group(0));
                    }
                }
                sum += Integer.parseInt(firstNumber + lastNumber);
            }
            System.out.println("The result of the 1/2 Advent of Code Puzzle is: " + sum);
        } finally {
            reader.close();
        }
    }
}