package rubti.adventofcode;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.HashMap;

public class Day1 implements Solution {
    ArrayList<String> puzzle;

    public Day1(ArrayList<String> puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public void solve() {
        int sumPartOne = 0;
        int sumPartTwo = 0;
        for (var input : puzzle) {
            sumPartOne += findNumbersOnly(input);
            sumPartTwo += considerWrittenNumbers(input);
        }
        System.out.println("The result of the 1/1 Advent of Code Puzzle is: " + sumPartOne);
        System.out.println("The result of the 1/2 Advent of Code Puzzle is: " + sumPartTwo);
    }

    private int findNumbersOnly(String input) {
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
        return Integer.parseInt(firstNumber + lastNumber);
    }

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

    private int considerWrittenNumbers(String input) {
        Pattern firstPattern = Pattern.compile("(one|two|three|four|five|six|seven|eight|nine|\\d)");
        Matcher firstMatcher = firstPattern.matcher(input);
        String firstNumber = null;
        if (firstMatcher.find()) {
            firstNumber = numbers.get(firstMatcher.group());
        }

        // Regex pattern to find the last number
        Pattern lastPattern = Pattern.compile(
                "(?:one|two|three|four|five|six|seven|eight|nine|\\d)(?!.*(one|two|three|four|five|six|seven|eight|nine|\\d))");
        Matcher lastMatcher = lastPattern.matcher(input);
        String lastNumber = null;
        if (lastMatcher.find()) {
            if (lastMatcher.group(1) != null) {
                lastNumber = numbers.get(lastMatcher.group(1));
            } else {
                lastNumber = numbers.get(lastMatcher.group(0));
            }
        }
        return Integer.parseInt(firstNumber + lastNumber);
    }
}
