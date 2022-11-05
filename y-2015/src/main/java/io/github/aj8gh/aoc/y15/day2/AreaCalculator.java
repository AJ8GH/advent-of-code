package io.github.aj8gh.aoc.y15.day2;

import java.util.Arrays;
import java.util.List;

public class AreaCalculator {

  private static final String DELIMITER = "x";

  public long calculate(List<String> dimensions) {
    return dimensions.stream()
        .map(line -> getArea(Arrays.stream(line.split(DELIMITER)).map(Integer::parseInt).toList()))
        .mapToInt(Integer::intValue)
        .reduce(0, Integer::sum);
  }

  private int getArea(List<Integer> list) {
    var l = list.get(0);
    var w = list.get(1);
    var h = list.get(2);

    var side1 = l * w;
    var side2 = w * h;
    var side3 = h * l;

    return 2 * (side1 + side2 + side3) + Math.min(side1, (Math.min(side2, side3)));
  }
}
