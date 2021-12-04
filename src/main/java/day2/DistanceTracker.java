package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceTracker {
    private static final String INPUT = "./src/main/java/day2/input.txt";
    private static final String FORWARD = "forward";
    private static final String DOWN = "down";
    private static final String UP = "up";
    private static final String DELIMITER = " ";

    private final Map<String, Integer> stepsMap = new HashMap<>();
    private final List<String> stepsList = new ArrayList<>();

    public static void main(String[] args) {
        var tracker = new DistanceTracker();

        // part 1
        tracker.deserializeInputPart1();
        System.out.println(tracker.stepsMap);
        System.out.println(tracker.getDistanceByDepth());

        // part 2
        tracker.deserializeInputPart2();
        System.out.println(tracker.getDistanceByDepthWithAim());
    }

    private void deserializeInputPart1() {
        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            String step;
            while ((step = reader.readLine()) != null) {
                String[] stepSplit = step.trim().split(DELIMITER);
                String direction = stepSplit[0];
                int distance = Integer.parseInt(stepSplit[1]);
                stepsMap.put(direction, stepsMap.getOrDefault(direction, 0) + distance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getDistanceByDepth() {
        int depth = stepsMap.get(DOWN) - stepsMap.get(UP);
        return depth * stepsMap.get(FORWARD);
    }

    private void deserializeInputPart2() {
        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            String step;
            while((step = reader.readLine()) != null) {
                stepsList.add(step.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getDistanceByDepthWithAim() {
        int aim = 0;
        int horizontalDistance = 0;
        int depth = 0;

        for (String step : stepsList) {
            String[] stepSplit = step.split(DELIMITER);
            String direction = stepSplit[0];
            int distance = Integer.parseInt(stepSplit[1]);

            if (direction.equals(DOWN)) aim += distance;
            if (direction.equals(UP)) aim -= distance;
            if (direction.equals(FORWARD)) {
                horizontalDistance += distance;
                if (aim != 0) depth += (aim * distance);
            }
        }
        return horizontalDistance * depth;
    }
}
