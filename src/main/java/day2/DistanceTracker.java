package day2;

import java.util.List;
import java.util.Map;

public class DistanceTracker {
    private static final String FORWARD = "forward";
    private static final String DOWN = "down";
    private static final String UP = "up";
    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        var tracker = new DistanceTracker();
        var deserializer = new Deserializer();

        // part 1
        var stepsMap = deserializer.deserializeInputPart1();
        int solution1 = tracker.getDistanceByDepth(stepsMap);
        System.out.println(solution1);

        // part 2
        var stepsList = deserializer.deserializeInputPart2();
        int solution2 = tracker.getDistanceByDepthWithAim(stepsList);
        System.out.println(solution2);
    }

    private int getDistanceByDepth(Map<String, Integer> stepsMap) {
        int depth = stepsMap.get(DOWN) - stepsMap.get(UP);
        return depth * stepsMap.get(FORWARD);
    }

    private int getDistanceByDepthWithAim(List<String> stepsList) {
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
