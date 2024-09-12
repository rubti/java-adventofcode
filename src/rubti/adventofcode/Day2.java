package rubti.adventofcode;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.HashMap;

public class Day2 implements Solution {
    private ArrayList<String> puzzle;

    public Day2(ArrayList<String> puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public void solve() {
        int sum_part_one = 0, sum_part_two = 0;
        for (var input : puzzle) {
            var parts = input.split(":");
            var min_red = maxCubes(parts[1], "red");
            var min_green = maxCubes(parts[1], "green");
            var min_blue = maxCubes(parts[1], "blue");
            sum_part_two += (min_red * min_green * min_blue);
            if (cubesInLimit(parts[1], "red") && cubesInLimit(parts[1], "blue")
                    && cubesInLimit(parts[1], "green")) {
                var pattern = Pattern.compile("\\d+");
                var matcher = pattern.matcher(parts[0]);
                matcher.find();
                sum_part_one += Integer.parseInt(matcher.group());
            }
        }
        System.out.println("Solution 2/1: The sum of IDs from the possible games is " + sum_part_one);
        System.out.println("Solution 2/2: The sum of powers is " + sum_part_two);
    }

    private static int colorNumber(String input, String color) {
        var pattern = Pattern.compile("(\\d+)(?= " + color + ")");
        var matcher = pattern.matcher(input);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(0));
        } else {
            return 0;
        }
    }

    private static int maxCubes(String input, String color) {
        var parts = input.split(";");
        int max = 0;
        for (var p : parts) {
            int numberCubes = colorNumber(p, color);
            if (numberCubes > max) {
                max = numberCubes;
            }
        }
        return max;
    }

    private static final HashMap<String, Integer> limits = new HashMap<>();
    static {
        limits.put("red", 12);
        limits.put("green", 13);
        limits.put("blue", 14);
    }

    private static Boolean cubesInLimit(String input, String color) {
        var parts = input.split(";");
        for (var p : parts) {
            if (colorNumber(p, color) > limits.get(color))
                return false;
        }
        return true;
    }
}