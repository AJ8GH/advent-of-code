package io.github.aj8gh.aoc.y21.d2;

import java.util.HashMap;
import java.util.List;

public class DistanceTracker {
  private static final String FORWARD = "forward";
  private static final String DOWN = "down";
  private static final String UP = "up";
  private static final String DELIMITER = " ";

  public int getDistanceByDepthPart1(List<String> input) {

    var stepsMap = new HashMap<String, Integer>();
    for (var line : input) {
      var stepSplit = line.trim().split(DELIMITER);
      String direction = stepSplit[0];
      int distance = Integer.parseInt(stepSplit[1]);
      stepsMap.put(direction, stepsMap.getOrDefault(direction, 0) + distance);
    }
    int depth = stepsMap.get(DOWN) - stepsMap.get(UP);
    return depth * stepsMap.get(FORWARD);
  }

  public int getDistanceByDepthPart2(List<String> input) {
    int aim = 0;
    int horizontalDistance = 0;
    int depth = 0;

    for (String step : input) {
      String[] stepSplit = step.split(DELIMITER);
      String direction = stepSplit[0];
      int distance = Integer.parseInt(stepSplit[1]);

      if (direction.equals(DOWN)) {
        aim += distance;
      }
      if (direction.equals(UP)) {
        aim -= distance;
      }
      if (direction.equals(FORWARD)) {
        horizontalDistance += distance;
        if (aim != 0) {
          depth += (aim * distance);
        }
      }
    }
    return horizontalDistance * depth;
  }
}
